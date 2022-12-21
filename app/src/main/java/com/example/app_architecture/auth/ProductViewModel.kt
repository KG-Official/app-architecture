package com.example.app_architecture.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.iServices.ProductServiceInterface
import com.example.core.model.Product
import com.example.service.ProductServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductViewModel : ViewModel() {

    val service:ProductServiceInterface by inject


    fun getProduct():LiveData<List<Product>> {
       return service.getProducts()
    }


   fun insertProduct(data: Product) {
        viewModelScope.launch(Dispatchers.IO) {

            service.insertProduct(data)
        }

    }
}