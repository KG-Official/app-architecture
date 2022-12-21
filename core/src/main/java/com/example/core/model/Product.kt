package com.example.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var productId:Long,
    var productName:String,
    var productPrice:String,
    var productQuantity: String
)
