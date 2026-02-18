package com.example.pizza.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pizza.ui.screens.CarritoScreen
import com.example.pizza.ui.screens.LoginScreen
import com.example.pizza.ui.screens.PizzaApp

@Composable
fun AppNavigation(){
    //Paso 1 Crear el Nav Controller
    val navController = rememberNavController()

    //Paso 2 Crear el Nav Host donde estaran todos los destinos

    NavHost(
        navController = navController, startDestination = Screens.Login.route
    ){
        //Paso 3 Declarar las rutas de navegacion
        composable(route= Screens.Login.route){
            LoginScreen( onLoginClick = {
                navController.navigate(Screens.PizzaList.route)
            })
        }
        composable(route= Screens.PizzaList.route){
            PizzaApp(
                onPizzaClick = {navController.navigate(Screens.Carrito.route)}
            )
        }

        composable(route = Screens.Carrito.route){
            CarritoScreen()
        }
    }
}