package com.learning.epl

import java.io.Serializable

data class SoccerTile(
    val id:String="",
    val title:String="",
    val description:String="",
    val descriptionLong:String="",
    val buttonText:String="",
    val ResourceImageId:Int=0,
    val headerImageUrl:String?=null,
    val teamUrl:String="",
    var isFavourite:Boolean=false
): Serializable