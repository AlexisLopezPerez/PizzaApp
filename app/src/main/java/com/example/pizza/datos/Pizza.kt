package com.example.pizza.datos

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

//DEFINIR NOMBRE DE TABLA
//El atributo INDICES busca en la columna "stringResourceId" y el UNIQUE = TRUE le dice que si encuentra un valor ya esta insertado no lo duplique
@Entity(tableName = "pizzas", indices = [Index(value = ["stringResourceId"], unique = true)] )
data class Pizza(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    val cantidad: Int
)