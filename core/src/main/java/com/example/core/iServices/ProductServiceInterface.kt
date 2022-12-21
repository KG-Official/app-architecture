package com.example.core.iServices

import androidx.lifecycle.LiveData
import com.example.core.model.Product

interface ProductServiceInterface {

    fun getProducts(): LiveData<List<Product>>
    suspend fun insertProduct(data: Product)


}