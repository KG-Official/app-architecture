package com.example.core.iLocalDataSource

import androidx.lifecycle.LiveData
import com.example.core.model.Product

interface LocalProductInterface {

    fun product():LiveData<List<Product>>
    suspend fun insertProduct(data: Product)
}