package com.example.pizza.datos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pizza::class, Pedido::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    //CONECTAR DAOS

    abstract fun pizzaDao(): PizzaDAO

    abstract fun pedidosDao(): PedidoDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pizza_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

