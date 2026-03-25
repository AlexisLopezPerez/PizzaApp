package com.example.pizza.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pizza.datos.Pizza
import com.example.pizza.viewModel.PizzaViewModel

@Composable
fun EditarPizza(pizza: Pizza,
                onEditarClick: (Pizza) -> Unit,
){
    val contexto = LocalContext.current

    var currentImageUri by remember { mutableStateOf<Uri?>(Uri.parse(pizza.imageUri)) }

    var cantidadPizza by remember { mutableStateOf(pizza.cantidad.toString()) }
    var textoPizza by remember { mutableStateOf(pizza.stringResourceId) }

    var galeryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null){
            try {
                //esto es para que android nos de permiso de acceder siempre a la imagen
                val contentResolver = contexto.contentResolver
                val takeFlags: Int = Intent.FLAG_GRANT_READ_URI_PERMISSION

                //Hacer que el permiso persista
                contentResolver.takePersistableUriPermission(uri, takeFlags)
                currentImageUri = uri
            }
            catch (e: Exception){
                currentImageUri = uri
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize().padding(20.dp))
    {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            AsyncImage(
                model = currentImageUri,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )

            OutlinedButton(
                onClick = {
                    galeryLauncher.launch("image/x")
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            {
                Text("Cambiar Foto")
            }

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = cantidadPizza,
                onValueChange = { cantidadPizza = it },
                label = { Text("Cantidad de pizzas") }
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    val nuevaCantidad = cantidadPizza.toIntOrNull()?: pizza.cantidad

                    val pizzaActualizada = pizza.copy(cantidad = nuevaCantidad, imageUri = currentImageUri.toString())

                    onEditarClick(pizzaActualizada)

                    Toast.makeText(
                        contexto,
                        "Imagen Actualizada",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
            {
                Text("Editar Pizza")
            }

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = textoPizza,
                onValueChange = { textoPizza = it },
                label = { Text("Descripcion de pizzas") }
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {

                }
            )
            {
                Text("Editar Pizza")
            }
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
private fun Preview(){
    EditarPizza(pizza = , onEditarClick = {})
}*/