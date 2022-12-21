package com.example.app_architecture

import android.app.Application
import com.example.app_architecture.auth.ProductViewModel
import com.example.core.iLocalDataSource.LocalProductInterface
import com.example.core.iNetworkDataSource.IAuthNetwork
import com.example.core.iServices.IAuthService
import com.example.core.iServices.ProductServiceInterface
import com.example.local_data_source.ProductDB.DatabaseHelper
import com.example.local_data_source.LocalProductImpl
import com.example.network_data_source.AuthNetworkImpl
import com.example.service.AuthServiceImpl
import com.example.service.ProductServiceImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.module


class MainApplication() : Application() {


    override fun onCreate() {
        super.onCreate()

        val dao = DatabaseHelper.getDatabase(this).productDao()


        val diModule = module {
            viewModel{ProductViewModel(get())}

            factory<LocalProductInterface> { LocalProductImpl(dao) }
            factory<IAuthService> { AuthServiceImpl(get(), get()) }
            factory<IAuthNetwork> { AuthNetworkImpl() }

            factory<ProductServiceInterface> { ProductServiceImpl(get(),get()) }
        }

        startKoin{
            diModule
        }
    }

    }

