package com.example.pizza.datos

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity("pedidos",
    foreignKeys = [
        ForeignKey(
            entity = Pizza::class,
            parentColumns = ["id"],
            childColumns = ["pizza_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Pedido(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fecha: String,
    val precio: Float,
    val Cantidad: Int,
    val pizza_id: Int
)

