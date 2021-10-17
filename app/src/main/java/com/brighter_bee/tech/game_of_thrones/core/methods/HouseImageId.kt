package com.brighter_bee.tech.game_of_thrones.core.methods

import com.brighter_bee.tech.game_of_thrones.R

fun houseImageId(houseSlugName: String) : Int {

    var imageId: Int = R.drawable.got_title

    when (houseSlugName) {
        "stark" -> imageId = R.drawable.stark
        "lannister" -> imageId = R.drawable.lannister
        "baratheon" -> imageId = R.drawable.baratheon
        "targaryen" -> imageId = R.drawable.targaryen
        "greyjoy" -> imageId = R.drawable.greyjoy
        "tarly" -> imageId = R.drawable.tarly
        "tarth" -> imageId = R.drawable.tarth
        "bolton" -> imageId = R.drawable.bolton
        "baelish" -> imageId = R.drawable.baelish
        "tyrell" -> imageId = R.drawable.tyrell
    }

    return imageId

}