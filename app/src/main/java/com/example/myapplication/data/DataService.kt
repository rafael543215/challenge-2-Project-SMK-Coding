package com.example.myapplication.data

import com.example.myapplication.item.BeritaCovid
import com.example.myapplication.item.CovidConfirmedItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DataService {
    @GET("api/confirmed")
    fun getConfirmed(): Call<List<CovidConfirmedItem>>

    @GET("api/deaths")
    fun getDeaths(): Call<List<CovidConfirmedItem>>

    @GET("api/recovered")
    fun getRecovered(): Call<List<CovidConfirmedItem>>

    @GET("/v2/top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Call<BeritaCovid>
}