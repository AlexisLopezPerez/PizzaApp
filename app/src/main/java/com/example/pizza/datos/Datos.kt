package com.example.pizza.datos

import com.example.pizza.Modelo.pizza
import com.example.pizza.R

class Datos {
    fun loadPizzas(): List<pizza> {
        return listOf<pizza>(
            pizza(R.string.hawaiana, R.drawable.hawaiana),
            pizza(R.string.pepperoni, R.drawable.pepperoni),
            pizza(R.string.queso, R.drawable.mozzarella),
            pizza(R.string.mexicana, R.drawable.mexicana),
            pizza(R.string.margarita, R.drawable.margarita),
            pizza(R.string.combinazione, R.drawable.combinazione),
            pizza(R.string.cuatro_estaciones, R.drawable.cuatro_estaciones)
        )
    }
}