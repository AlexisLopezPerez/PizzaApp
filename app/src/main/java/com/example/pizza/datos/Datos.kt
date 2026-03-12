package com.example.pizza.datos

import com.example.pizza.datos.Pizza
import com.example.pizza.R

class Datos {
    fun loadPizzas(): List<Pizza> {
        return listOf<Pizza>(
            Pizza(stringResourceId = R.string.hawaiana, imageResourceId = R.drawable.hawaiana, cantidad = 8),
            Pizza(stringResourceId = R.string.pepperoni, imageResourceId = R.drawable.pepperoni, cantidad = 4),
            Pizza(stringResourceId = R.string.queso, imageResourceId = R.drawable.mozzarella, cantidad = 3),
            Pizza(stringResourceId = R.string.mexicana,imageResourceId =  R.drawable.mexicana, cantidad = 9),
            Pizza(stringResourceId = R.string.margarita, imageResourceId = R.drawable.margarita, cantidad = 18),
            Pizza(stringResourceId = R.string.combinazione,imageResourceId =  R.drawable.combinazione, cantidad = 11),
            Pizza(stringResourceId = R.string.cuatro_estaciones, imageResourceId = R.drawable.cuatro_estaciones, cantidad = 8)
        )
    }
}