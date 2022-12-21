package com.example.local_data_source.ProductDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.core.model.Product

@Dao
interface ProductDao {
    @Insert
    suspend  fun insertProduct(product: Product)

    @Update
    suspend  fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM Product ORDER BY productId DESC")
    fun getProduct() : LiveData<List<Product>>



}