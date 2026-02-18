package com.example.pizza.ui.navigation

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pizza.ui.screens.CarritoScreen
import com.example.pizza.ui.screens.LoginScreen
import com.example.pizza.ui.screens.PizzaApp
import com.example.pizza.ui.theme.PizzaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(){
    //Paso 1 Crear el Nav Controller
    val navController = rememberNavController()

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(title = { Text("Chess Pizza") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                    navigationIcon = { IconButton(onClick = {navController.popBackStack()}) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Flechita :)"
                        ) } }
                )

            }

        ) { innerPading ->
            Box(modifier = Modifier.padding(innerPading)){
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
        }



}

@Preview
@Composable
private fun Preview(){
    PizzaTheme {
        AppNavigation()
    }

}