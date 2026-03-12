package com.example.pizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
/*import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource*/
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.pizza.R
import com.example.pizza.datos.Datos
import com.example.pizza.datos.Pizza
import com.example.pizza.ui.theme.PizzaTheme
import com.example.pizza.viewModel.PizzaViewModel

@Composable
fun PizzaCard(onPizzaClick: () -> Unit, pizza: Pizza, cantidad: Int, onAgregarClick: () -> Unit, onQuitarClick: () -> Unit, modifier: Modifier = Modifier){

    Card(modifier = modifier,
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primaryContainer
        )) {
        Column {
            Image(painter = painterResource(pizza.imageResourceId),
                contentDescription = stringResource(pizza.stringResourceId),
                modifier = modifier.fillMaxWidth().height(194.dp),
                contentScale = ContentScale.Crop)

            Text(modifier = modifier.padding(16.dp),
                text = stringResource(pizza.stringResourceId),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer)

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){

                Button(modifier = modifier, onClick = {onQuitarClick()}, enabled = cantidad<pizza.cantidad ) { Text("-") }

                Text(text= "$cantidad", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onPrimaryContainer)

                Button(modifier = modifier, onClick = {onAgregarClick()}) { Text("+") }

                Button(modifier = modifier, onClick = {onPizzaClick()}) { Text(text = stringResource(id = R.string.agregarCarrito)) }
            }
        }
    }
}

@Composable
fun PizzaApp(onPizzaClick: () -> Unit, viewModel: PizzaViewModel = viewModel(), modifier: Modifier = Modifier){
    val pizzaList by viewModel.pizzaList.collectAsState(initial = emptyList())
    ListaDePizzas(onPizzaClick = onPizzaClick ,pizzaList = pizzaList, viewModel)
}

@Preview (showBackground = true)
@Composable
private fun PizzaCardPreview(){
    PizzaTheme{
        PizzaApp(onPizzaClick = {})
    }
}

@Composable
fun ListaDePizzas(onPizzaClick: () -> Unit, pizzaList: List<Pizza>, viewModel: PizzaViewModel,modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(pizzaList){
                pizza -> PizzaCard(onPizzaClick = onPizzaClick, pizza = pizza,
            cantidad = viewModel.obtenerCantidad(pizza.stringResourceId),
            onAgregarClick = {viewModel.agregarAlCarrito(pizza.stringResourceId)},
            onQuitarClick = {viewModel.quitarDelCarrito(pizza.stringResourceId)}, modifier = Modifier.padding(8.dp))
        }
    }
}