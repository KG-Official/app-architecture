package com.example.service

import androidx.lifecycle.LiveData
import com.example.core.iLocalDataSource.LocalProductInterface
import com.example.core.iNetworkDataSource.IAuthNetwork
import com.example.core.iServices.ProductServiceInterface
import com.example.core.model.Product

class ProductServiceImpl(val localData:LocalProductInterface, val networkData:IAuthNetwork):ProductServiceInterface {
    override fun getProducts(): LiveData<List<Product>> {
        return localData.product()
    }

    override suspend fun insertProduct(data: Product) {
        localData.insertProduct(data)
        //xyx.insert
    }


}