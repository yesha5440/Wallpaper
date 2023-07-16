package com.example.wallpaper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIinterface {
    @GET("search")
    fun getPhotos(
        @Header("Authorization")auth: String,
        @Query("query")query: String
    ) : Call<PhotoModel>

    fun getphotos(auth: String, txt: String): Any


}