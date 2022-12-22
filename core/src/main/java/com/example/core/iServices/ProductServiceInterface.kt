package com.example.core.iServices

import androidx.lifecycle.LiveData
import com.example.core.iNetworkDataSource.API_KEY
import com.example.core.model.ApiModel.News
import com.example.core.model.Product
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductServiceInterface {

    fun getProducts(): LiveData<List<Product>>
    suspend fun insertProduct(data: Product)

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String, @Query("page")page:Int): retrofit2.Call<News>


}