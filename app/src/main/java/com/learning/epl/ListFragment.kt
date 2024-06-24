package com.learning.epl

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class ListFragment :BaseMainActivityFragment(R.layout.fragment_list){

    private lateinit var soccerTileAdapter:SoccerTileAdapter

    private val soccerTileList:ArrayList<SoccerTile>
        get()=mainActivity.soccerTileList


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainActivity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            title="EPL HOME"
        }
        soccerTileAdapter=SoccerTileAdapter(soccerTileList,activity as MainActivity)
        val recyclerView=view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter=soccerTileAdapter
    }
    override fun onResume() {
        super.onResume()
        soccerTileAdapter.notifyDataSetChanged()
    }

    fun onFavouriteClicked(position:Int){
        soccerTileAdapter.notifyItemChanged(position)
    }
}
