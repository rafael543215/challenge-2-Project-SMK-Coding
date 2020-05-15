package com.example.myapplication.data

import Attributes
import CovidDataItem
import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET("Attributes")
    fun getAttributes():Call<List<Attributes>>
}