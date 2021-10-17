package com.brighter_bee.tech.game_of_thrones.core.methods

import com.brighter_bee.tech.game_of_thrones.R

fun characterImageId(characterSlugName: String): Int {

    var imageId: Int = R.drawable.got_title

    when (characterSlugName) {
        "jon" -> imageId = R.drawable.jon
        "sansa" -> imageId = R.drawable.sansa
        "ned" -> imageId = R.drawable.ned
        "jaime" -> imageId = R.drawable.jaime
        "tyrion" -> imageId = R.drawable.tyrion
        "cersei" -> imageId = R.drawable.cersei
        "joffrey" -> imageId = R.drawable.joffrey
        "aerys" -> imageId = R.drawable.aerys
        "daenerys" -> imageId = R.drawable.daenerys
        "tywin" -> imageId = R.drawable.tywin
        "ramsay" -> imageId = R.drawable.ramsay
        "arya" -> imageId = R.drawable.arya
        "robert" -> imageId = R.drawable.robert
        "theon" -> imageId = R.drawable.theon
        "samwell" -> imageId = R.drawable.samwell
        "varys" -> imageId = R.drawable.varys
        "bran" -> imageId = R.drawable.bran
        "brienne" -> imageId = R.drawable.brienne
        "baelish" -> imageId = R.drawable.baelish
        "tormund" -> imageId = R.drawable.tormund
        "melisandre" -> imageId = R.drawable.melisandre
        "olenna" -> imageId = R.drawable.olenna
        "mance" -> imageId = R.drawable.mance
    }

    return imageId
}