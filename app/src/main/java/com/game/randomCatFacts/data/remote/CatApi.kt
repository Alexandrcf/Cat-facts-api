package com.game.randomCatFacts.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers

interface CatApi {

    @GET("/fact")
    @Headers("Content-Type: application/json")
    suspend fun getCatList(): CatListItem
}