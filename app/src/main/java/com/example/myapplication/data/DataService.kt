package com.example.myapplication.data

import com.example.myapplication.item.CovidConfirmedItem
import com.example.myapplication.item.CovidCountryConfirmedItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DataService {
    @GET("api/confirmed")
    fun getConfirmed(): Call<List<CovidConfirmedItem>>

    @GET("api/deaths")
    fun getDeaths(): Call<List<CovidConfirmedItem>>

    @GET("api/recovered")
    fun getRecovered(): Call<List<CovidConfirmedItem>>

    @GET("api/countries/{country}/confirmed")
    fun getCountryConfirm(@Path("country") country: String): Call<List<CovidCountryConfirmedItem>>
}