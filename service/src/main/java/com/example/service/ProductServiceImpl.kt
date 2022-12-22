package com.example.service

import androidx.lifecycle.LiveData
import com.example.core.iLocalDataSource.LocalProductInterface
import com.example.core.iNetworkDataSource.NetworkNewsInterface
import com.example.core.iServices.ProductServiceInterface
import com.example.core.model.ApiModel.News
import com.example.core.model.Product
import retrofit2.Call

class ProductServiceImpl(val localData:LocalProductInterface, val networkData:NetworkNewsInterface):ProductServiceInterface {
    override fun getProducts(): LiveData<List<Product>> {
        return localData.product()
    }

    override suspend fun insertProduct(data: Product) {
        localData.insertProduct(data)
    }

    override fun getHeadlines(country: String, page: Int): Call<News> {
        return networkData.getHeadlines(country,page)
    }


}