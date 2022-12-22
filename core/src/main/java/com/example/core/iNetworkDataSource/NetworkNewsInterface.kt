package com.example.core.iNetworkDataSource

import android.telecom.Call
import retrofit2.http.Query
import com.example.core.model.ApiModel.News
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "ec37cd2f412d42ca9409d6b3beb2c73c"

interface NetworkNewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String,@Query("page")page:Int): retrofit2.Call<News>
}

object NewsService{

    val newsInstance : NetworkNewsInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
        newsInstance = retrofit.create(NetworkNewsInterface::class.java)


    }
}