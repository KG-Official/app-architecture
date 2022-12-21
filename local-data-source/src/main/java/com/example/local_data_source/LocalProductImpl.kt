package com.example.local_data_source

import androidx.lifecycle.LiveData
import com.example.core.iLocalDataSource.LocalProductInterface
import com.example.core.model.Product
import com.example.local_data_source.ProductDB.ProductDao

class LocalProductImpl(val productDao: ProductDao):LocalProductInterface {

    override fun product(): LiveData<List<Product>> {
        return productDao.getProduct()
    }

    override suspend fun insertProduct(data: Product) {
        productDao.insertProduct(data)
    }

}