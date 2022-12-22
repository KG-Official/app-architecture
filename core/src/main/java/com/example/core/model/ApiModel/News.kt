package com.example.core.model.ApiModel

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)