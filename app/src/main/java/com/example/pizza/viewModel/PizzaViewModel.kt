package com.example.pizza.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pizza.datos.Datos

import com.example.pizza.datos.PizzaDAO


class PizzaViewModel(private val pizzaDAO: PizzaDAO): ViewModel() {
    //private val _pizzas = mutableStateOf(value = Datos().loadPizzas())
    private val _carrito = mutableStateMapOf<Int, Int>()

    val pizzaList = pizzaDAO.getAllpizzas()
    fun obtenerCantidad(pizzaID: Int): Int = _carrito[pizzaID]?: 0

    fun agregarAlCarrito(pizzaID: Int){
        val actual = _carrito[pizzaID] ?: 0
        _carrito[pizzaID] = actual + 1
    }

    //No estaba en la clase
    fun quitarDelCarrito(pizzaID: Int){
        val actual = _carrito[pizzaID] ?: 0
        _carrito[pizzaID] = maxOf(0,actual - 1)
    }

    //val pizzaList: State<List<pizza>> = _pizzas
}