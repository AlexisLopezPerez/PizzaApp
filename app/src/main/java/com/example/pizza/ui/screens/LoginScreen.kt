package com.example.pizza.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(onLoginClick: () -> Unit){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Bienvenidos a Chess Pizza", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = onLoginClick) { Text(text = "Entrar al menu") }
    }
}

@Preview
@Composable
fun Preview(){
    LoginScreen(onLoginClick = {})
}