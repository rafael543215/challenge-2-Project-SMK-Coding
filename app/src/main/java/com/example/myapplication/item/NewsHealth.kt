package com.example.myapplication


import com.example.myapplication.item.Article
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsHealth(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<Article>

): Serializable