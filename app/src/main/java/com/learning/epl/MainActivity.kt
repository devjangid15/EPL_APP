package com.learning.epl

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() ,SoccerTileInterface{

    lateinit var soccerTileList:ArrayList<SoccerTile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Adding Fragment to Work with Main activity
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragmentContainerView,ListFragment())
        }

        supportActionBar?.apply {
            title="EPL Home"
        }
        soccerTileList=getList()
    }
    override fun onLearnMoreButtonClicked(position: Int) {

        val soccerTile=soccerTileList[position]

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            val bundle=Bundle().apply {
                putString("soccerTileId",soccerTile.id)
            }
            replace(R.id.fragmentContainerView,DetailFragment().apply {
                arguments=bundle
            })
        }
    }

    override fun onFavouriteClicked(position: Int) {
        val soccerTile= soccerTileList[position]
        soccerTile.isFavourite=!soccerTile.isFavourite

        (supportFragmentManager.fragments[0] as ListFragment)?.onFavouriteClicked(position)

    }

    private fun getList():ArrayList<SoccerTile>{
        return ArrayList<SoccerTile>().apply {
            add(
                SoccerTile(
                id="manchester",
                title="Manchester United",
                description = " Desciption of Manchester will",
                descriptionLong = "Longer Description of MANCHESTER is present here",
                buttonText = "Read More",
                ResourceImageId = R.drawable.manchester_city_logo_b82cd2bbf5_seeklogo_com,
                headerImageUrl = "https://imgs.search.brave.com/1PQYpAul5HcSsYvSd8vIBJuSeEzQV3SUpW8K9Y-pEWM/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9zZWVr/bG9nby5jb20vaW1h/Z2VzL00vbWFuY2hl/c3Rlci1jaXR5LWxv/Z28tQjgyQ0QyQkJG/NS1zZWVrbG9nby5j/b20ucG5n",
                teamUrl = "https://www.manutd.com/"
            )
            )

            add(
                SoccerTile(
                id="arsenal",
                title="Arsenal United",
                description = " Desciption of Arsenal United will",
                descriptionLong = "Longer Description of ARSENAL is present here",
                buttonText = "Read More",
                ResourceImageId = R.drawable.arsenal,
                headerImageUrl = "https://imgs.search.brave.com/C7uD2T89OkUyqQOAKEmWAnlsf5wnjQFunYZ8vdpRZT8/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9hc3Nl/dHMuc3RpY2twbmcu/Y29tL2ltYWdlcy81/ODBiNTdmY2Q5OTk2/ZTI0YmM0M2M0ZGYu/cG5n",
                teamUrl = "https://www.arsenal.com/"
            )
            )

            add(
                SoccerTile(
                id="chelsa",
                title="Chelsa United",
                description = " Desciption of Chelsa United will",
                descriptionLong = "Longer Description of CHELSEA is present here",
                buttonText = "Read More",
                ResourceImageId = R.drawable.chelsea,
                headerImageUrl = "https://imgs.search.brave.com/4FuffmuD_096W8q7mtZVa93H3BgET66xZT1QdLaXFIQ/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9hc3Nl/dHMuc3RpY2twbmcu/Y29tL2ltYWdlcy81/ODBiNTdmY2Q5OTk2/ZTI0YmM0M2M0ZTEu/cG5n",
                teamUrl = "https://chelseafc.com/en"
                )
            )

            add(
                SoccerTile(
                id="brentford",
                title="Brentford United",
                description = " Desciption of club will",
                descriptionLong = "Longer Description of Brentford United is present here",
                buttonText = "Read More",
                ResourceImageId = R.drawable.brentford,
                headerImageUrl = "https://imgs.search.brave.com/YsHQ3FOELFbkWR2LKkELB_Bz49dT9I-BADcHrgyTAls/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9jZG4u/YmxlYWNoZXJyZXBv/cnQubmV0L2ltYWdl/cy90ZWFtX2xvZ29z/LzMyOHgzMjgvYnJl/bnRmb3JkLnBuZw",
                teamUrl = "https://www.espn.com/soccer/report?gameId=638211"
            )
            )

            add(
                SoccerTile(
                id="everton",
                title="Everton United",
                description = " Desciption of Everton United will",
                descriptionLong = "Longer Description of Everton United is present here",
                buttonText = "Read More",
                ResourceImageId = R.drawable.everton,
                headerImageUrl = "https://imgs.search.brave.com/TjwmNT618jDMHo9jcNCDTWW7drigkaZa6jPsgp_XNiI/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9jZG4u/YmxlYWNoZXJyZXBv/cnQubmV0L2ltYWdl/cy90ZWFtX2xvZ29z/LzMyOHgzMjgvZXZl/cnRvbi5wbmc",
                teamUrl = "https://www.evertonfc.com/"
            )
            )

        }
    }
}