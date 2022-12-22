package com.example.app_architecture

import android.app.Application
import com.example.app_architecture.auth.ProductViewModel
import com.example.core.iLocalDataSource.LocalProductInterface
import com.example.core.iNetworkDataSource.NetworkNewsInterface
import com.example.core.iServices.ProductServiceInterface
import com.example.local_data_source.ProductDB.DatabaseHelper
import com.example.local_data_source.LocalProductImpl
import com.example.network_data_source.NetworkNewsInterfaceImpl
import com.example.service.ProductServiceImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


class MainApplication() : Application() {


    override fun onCreate() {
        super.onCreate()
        val dao = DatabaseHelper.getDatabase(this).productDao()

        val diModule = module {
            viewModel { ProductViewModel(get()) }

            factory<LocalProductInterface> { LocalProductImpl(dao) }
            factory<NetworkNewsInterface> { NetworkNewsInterfaceImpl() }
            factory<ProductServiceInterface> { ProductServiceImpl(get(), get()) }
        }

        startKoin {
            modules(diModule)

        }
    }

}

