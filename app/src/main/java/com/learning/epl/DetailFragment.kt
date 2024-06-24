@file:Suppress("DEPRECATION")

package com.learning.epl

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailFragment:BaseMainActivityFragment(R.layout.fragment_detail){

    private val soccerTile:SoccerTile by lazy {
        mainActivity.soccerTileList.find{
            it.id==requireArguments().getString("soccerTileId")
        }!!
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        mainActivity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title="Club Details"
        }

        val headerImageView: ImageView =view.findViewById(R.id.imageView)
        val titleTextView: TextView =view.findViewById(R.id.titleTextView)
        val description: TextView =view.findViewById(R.id.descriptionTextView)
        val descriptionLong: TextView =view.findViewById(R.id.descriptionLongTextView)


        headerImageView.setImageResource(soccerTile.ResourceImageId)
        titleTextView.text=soccerTile.title
        description.text=soccerTile.description
        descriptionLong.text=soccerTile.descriptionLong

        Picasso.get().isLoggingEnabled=true
        Picasso.get().load(soccerTile.headerImageUrl).into(headerImageView)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_soccer_tile_details,menu)

        if(soccerTile.isFavourite){
            menu.findItem(R.id.menuItemFavourite)?.setIcon(R.drawable.ic_favourite_24)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home->{
                (activity as MainActivity).supportFragmentManager.popBackStack()
                true
            }
            R.id.menuItemLink->{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(soccerTile.teamUrl))
                startActivity(intent)
                true
            }
            R.id.menuItemFavourite->{
                val isCurrentlyFavourite=soccerTile.isFavourite
                if(isCurrentlyFavourite){
                    item.setIcon(R.drawable.ic_favorite_border_24)
                }
                else{
                    item.setIcon(R.drawable.ic_favourite_24)
                }
                soccerTile.isFavourite=!isCurrentlyFavourite
                true
            }
            else-> super.onOptionsItemSelected(item)
        }

    }
}