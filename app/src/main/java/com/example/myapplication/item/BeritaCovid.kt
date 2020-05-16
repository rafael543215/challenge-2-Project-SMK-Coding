package com.example.myapplication.item


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BeritaCovid(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<Article>

): Serializable