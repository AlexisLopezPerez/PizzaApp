package com.example.pizza.ui.navigation

sealed class Screens (val route: String){
    object Login: Screens("login")
    object PizzaList: Screens("pizzas")
    object Carrito: Screens("carrito")
}