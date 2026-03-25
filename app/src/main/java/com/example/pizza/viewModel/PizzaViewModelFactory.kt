package com.example.pizza.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizza.datos.PizzaDAO


class pizzaViewModelFactory(private val dao: PizzaDAO, private val contexto: Context) : ViewModelProvider.Factory {

        // 2. función que Android llama cuando necesita el ViewModel
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PizzaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PizzaViewModel(dao, contexto) as T
            }
            throw IllegalArgumentException("No se pudo crear este ViewModel")
        }
}
