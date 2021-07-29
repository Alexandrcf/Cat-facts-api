package com.game.randomCatFacts.data.remote

import com.google.gson.annotations.SerializedName

data class CatListItem(
    @SerializedName("fact")
    val factId: String
)
