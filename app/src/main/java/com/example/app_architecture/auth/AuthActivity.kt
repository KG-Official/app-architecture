package com.example.app_architecture.auth

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.app_architecture.MainApplication
import com.example.app_architecture.databinding.ActivityAuth2Binding
import com.example.core.iNetworkDataSource.NewsService
import com.example.core.model.ApiModel.News
import com.example.core.model.Product
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuth2Binding
    private val productViewModel: ProductViewModel by viewModel()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuth2Binding.inflate(layoutInflater)
        setContentView(binding.root)


////////////////////////Inserting and Fetching Data From Database

        binding.btnInsert.setOnClickListener {

            val proName = binding.proName.text.toString()
            val proPrice = binding.proPrice.text.toString()
            val proQuantity = binding.proStock.text.toString()
            val product = Product(0, proName, proPrice, proQuantity)
            productViewModel.insertProduct(product)
        }

        productViewModel.getProduct().observe(this, Observer {
            Log.d("main", "My Data is $it \n")

        })

////////////////////////end Inserting and Fetching Data From Database
//////////////////////// Fetching Data From Api


        val news = productViewModel.getApiData("us", 1)

        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {

                val news = response.body()
                if (news != null) {
                    Log.d("MY News", "total news " + news.articles)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MY News", "total news ")
            }
        })

//////////////////////// end Fetching Data From Api


    }
}