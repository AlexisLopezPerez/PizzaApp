package com.example.pizza.datos

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey

//DEFINIR NOMBRE DE TABLA
@Entity("pizzas")
data class Pizza(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    val cantidad: Int
)