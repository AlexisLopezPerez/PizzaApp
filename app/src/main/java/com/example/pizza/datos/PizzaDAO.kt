package com.example.pizza.datos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDAO {
    @Query("SELECT * FROM pizzas")
    fun getAllpizzas(): Flow<List<Pizza>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pizza: Pizza)
}



