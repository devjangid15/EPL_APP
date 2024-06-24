package com.learning.epl

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

class SoccerTileAdapter(
    private val data:ArrayList<SoccerTile>,
    private val soccerTileInterface: SoccerTileInterface):RecyclerView.Adapter<SoccerTileAdapter.SoccerTileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoccerTileViewHolder {
        return SoccerTileViewHolder(parent)
    }

    override fun onBindViewHolder(holder: SoccerTileViewHolder, position: Int) {
        holder.onBind(data[position],soccerTileInterface)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class SoccerTileViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_soccer_tile,parent,false)
    ){
        private val headerImageView:ImageView=itemView.findViewById(R.id.imageView)
        private val titleTextView:TextView=itemView.findViewById(R.id.titleTextView)
        private val description:TextView=itemView.findViewById(R.id.descriptionTextView)
        private val button:Button=itemView.findViewById(R.id.button)
        private val favouriteImage:AppCompatImageView=itemView.findViewById(R.id.favouriteImageView)

        fun onBind(soccerTile: SoccerTile,soccerTileInterface: SoccerTileInterface){
            headerImageView.setImageResource(soccerTile.ResourceImageId)
            titleTextView.text=soccerTile.title
            description.text=soccerTile.description
            button.setOnClickListener {
                soccerTileInterface.onLearnMoreButtonClicked(adapterPosition)
            }

            if(soccerTile.isFavourite){
                favouriteImage.setImageResource(R.drawable.ic_favourite_24)
            }
            else{
                favouriteImage.setImageResource((R.drawable.ic_favorite_border_24))
            }

            favouriteImage.setOnClickListener{
                soccerTileInterface.onFavouriteClicked(adapterPosition)
            }
        }
    }
}