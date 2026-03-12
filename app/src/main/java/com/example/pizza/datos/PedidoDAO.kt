package com.example.pizza.datos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PedidoDAO {
    @Query("SELECT * FROM pedidos")
    fun getAllpedidos(): Flow<List<Pedido>>

    @Insert
    fun insert(pedido: Pedido)
}