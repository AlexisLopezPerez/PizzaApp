package com.example.pizza.viewModel

import androidx.lifecycle.ViewModel
import com.example.pizza.datos.PizzaDAO

class PizzaDAOViewModel(private val pizzaDAO: PizzaDAO): ViewModel() {
    val todasPizza = pizzaDAO.getAllpizzas()
}