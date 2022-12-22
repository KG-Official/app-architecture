package com.example.app_architecture.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.iServices.ProductServiceInterface
import com.example.core.model.ApiModel.News
import com.example.core.model.Product
import com.example.service.ProductServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call


class ProductViewModel(val service: ProductServiceInterface) : ViewModel() {

    /////For Local Data call
    fun getProduct(): LiveData<List<Product>> {
        return service.getProducts()
    }

    fun getApiData(country: String, page: Int): Call<News> {
        return service.getHeadlines(country, page)
    }

    ///// For Api Data call
    fun insertProduct(data: Product) {
        viewModelScope.launch(Dispatchers.IO) {

            service.insertProduct(data)
        }
    }
}