package com.example.network_data_source

import android.util.Log
import android.widget.Toast
import com.example.core.iNetworkDataSource.BASE_URL
import com.example.core.iNetworkDataSource.NetworkNewsInterface
import com.example.core.iNetworkDataSource.NewsService
import com.example.core.model.ApiModel.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkNewsInterfaceImpl():NetworkNewsInterface {
    override fun getHeadlines(country: String, page: Int): Call<News> {

            val news = NewsService.newsInstance.getHeadlines(country,page)

        return news

    }

}