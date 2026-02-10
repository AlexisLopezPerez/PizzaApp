package com.example.pizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizza.Modelo.pizza
import com.example.pizza.datos.Datos
import com.example.pizza.ui.theme.PizzaTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaTheme {
                PizzaApp()
            }
        }
    }
}

@Composable
fun PizzaApp(){
    ListaDePizzas(pizzaList = Datos().loadPizzas())
}

@Composable
fun PizzaCard(pizza: pizza, modifier: Modifier = Modifier){
    var cant by remember { mutableIntStateOf(0) }
    Card(modifier = modifier) {
        Column {
            Image(painter = painterResource(pizza.imageResourceId),
                contentDescription = stringResource(pizza.stringResourceId),
                modifier = modifier.fillMaxWidth().height(194.dp),
                contentScale = ContentScale.Crop)

            Text(modifier = modifier.padding(16.dp),
                text = LocalContext.current.getString(pizza.stringResourceId),
                style = MaterialTheme.typography.headlineSmall,)

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){

                Button(modifier = modifier, onClick = {if(cant>0) cant--}) { Text("-") }

                Text(text= "$cant")

                Button(modifier = modifier, onClick = {cant++}) { Text("+") }

                Button(modifier = modifier, onClick = {}) { Text(text = stringResource(id = R.string.agregarCarrito)) }
            }
        }
    }
}

@Preview
@Composable
private fun PizzaCardPreview(){
    PizzaApp()
}

@Composable
fun ListaDePizzas(pizzaList: List<pizza>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(pizzaList){
            pizza -> PizzaCard(pizza = pizza, modifier = Modifier.padding(8.dp))
        }
    }
}