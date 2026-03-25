package com.example.pizza.datos

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pizza.datos.Pizza
import com.example.pizza.R

class Datos(private val context: Context) {

    val packageName = context.packageName
    fun loadPizzas(): List<Pizza> {
        return listOf<Pizza>(
            Pizza(stringResourceId = "Pizza con queso y piña",
                //imageResourceId = R.drawable.hawaiana,
                //android.resource://[paquete]/[id_recurso]
                imageUri = "android.resource://$packageName/${R.drawable.hawaiana}",
                cantidad = 8),
            Pizza(stringResourceId = "Pizza con queso y pepperoni",
                //imageResourceId = R.drawable.pepperoni,
                imageUri = "android.resource://$packageName/${R.drawable.pepperoni}",
                cantidad = 4),
            Pizza(stringResourceId = "Pizza con doble queso",
                //imageResourceId = R.drawable.mozzarella,
                imageUri = "android.resource://$packageName/${R.drawable.mozzarella}",
                cantidad = 3),
            Pizza(stringResourceId = "Pizza con queso, carne, rajas, aceitunas, pimientos y cebolla",
                //imageResourceId =  R.drawable.mexicana,
                imageUri = "android.resource://$packageName/${R.drawable.mexicana}",
                cantidad = 9),
            Pizza(stringResourceId = "Pizza con queso, albaca y tomate",
                //    imageResourceId = R.drawable.margarita,
                imageUri = "android.resource://$packageName/${R.drawable.margarita}",
                cantidad = 18),
            Pizza(stringResourceId = "Pizza con queso, longaniza, chorizo, champiñones, pimiento y cebolla",
                //imageResourceId =  R.drawable.combinazione,
                imageUri = "android.resource://$packageName/${R.drawable.combinazione}",
                cantidad = 11),
            Pizza(stringResourceId = "Pizza con champiñones, pepperoni, piña y queso",
                //imageResourceId = R.drawable.cuatro_estaciones,
                imageUri = "android.resource://$packageName/${R.drawable.cuatro_estaciones}",
                cantidad = 8)
        )
    }
}