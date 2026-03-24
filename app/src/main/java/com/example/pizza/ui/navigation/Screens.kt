package com.example.pizza.ui.navigation

sealed class Screens (val route: String){
    data object Login: Screens("login")
    data object PizzaList: Screens("pizzas")
    data object Carrito: Screens("carrito")
    data object PizzaEdit: Screens("pizza_editar/{pizzaId}"){
        fun createRoute(pizzaId: Int) = "pizza_editar/$pizzaId"
    }
}