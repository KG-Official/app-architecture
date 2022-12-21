package com.example.app_architecture.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.app_architecture.MainApplication
import com.example.app_architecture.databinding.ActivityAuth2Binding
import com.example.core.model.Product
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuthActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAuth2Binding
    private val productViewModel:ProductViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuth2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnInsert.setOnClickListener {

            val proName = binding.proName.text.toString()
            val proPrice = binding.proPrice.text.toString()
            val proQuantity = binding.proStock.toString()

            val product = Product(0,"flower","65","56")

            productViewModel.insertProduct(product)
        }
        productViewModel.getProduct().observe(this, Observer {
            Log.d("main","My Data is $it")

        })
    }
}