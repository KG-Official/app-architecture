package com.example.local_data_source.ProductDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.model.Product

@Database(entities = [Product::class], version = 1)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseHelper? = null
        fun getDatabase(context: Context): DatabaseHelper {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context,
                            DatabaseHelper::class.java,
                            "myDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}
