package com.example.pizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizza.Modelo.pizza
import com.example.pizza.R
import com.example.pizza.ui.theme.PizzaTheme

@Composable
fun CarritoScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier.padding(20.dp),
            text = "Mi carrito de compras",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        Card(modifier = modifier.padding(15.dp),
            colors = CardDefaults.cardColors(
                contentColor = MaterialTheme.colorScheme.primaryContainer
            )) {
            Row {
                Image(
                    painter = painterResource(R.drawable.pepperoni),
                    contentDescription = stringResource(R.string.pepperoni),
                    modifier = modifier.height(100.dp).width(100.dp),
                    contentScale = ContentScale.Crop
                )
            Column() {
                Text(
                    modifier = modifier.padding(16.dp),
                    text = stringResource(R.string.pepperoni),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Row() {
                    Text(
                        modifier = modifier.padding(8.dp),
                        text = "Cantidad: #",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        modifier = modifier.padding(8.dp),
                        text = "Precio: $$$",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            }
        }
        Card(modifier = modifier.padding(15.dp),
            colors = CardDefaults.cardColors(
                contentColor = MaterialTheme.colorScheme.primaryContainer
            )) {
            Row {
                Image(
                    painter = painterResource(R.drawable.hawaiana),
                    contentDescription = stringResource(R.string.hawaiana),
                    modifier = modifier.height(100.dp).width(100.dp),
                    contentScale = ContentScale.Crop
                )
                Column() {
                    Text(
                        modifier = modifier.padding(16.dp),
                        text = stringResource(R.string.hawaiana),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Row() {
                        Text(
                            modifier = modifier.padding(16.dp),
                            text = "Cantidad: #",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            modifier = modifier.padding(16.dp),
                            text = "Precio: $$$",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
        Text(
            modifier = modifier.padding(20.dp),
            text = "Total: $$$$",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Button(
            onClick = {}
        ) {
            Text(
                text = "Pagar"
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
 private fun Preview(){
    PizzaTheme {
        CarritoScreen()
    }
}