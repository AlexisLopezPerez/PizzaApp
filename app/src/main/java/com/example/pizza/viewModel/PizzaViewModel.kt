package com.example.pizza.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizza.datos.Datos
import com.example.pizza.datos.Pizza

import com.example.pizza.datos.PizzaDAO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class PizzaViewModel(private val pizzaDAO: PizzaDAO): ViewModel() {
    //private val _pizzas = mutableStateOf(value = Datos().loadPizzas())
    private val _carrito = mutableStateMapOf<Int, Int>()

    val pizzaList = pizzaDAO.getAllpizzas().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )
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

    //El INIT hace que el codigo se ejecute en paralelo al iniciar la app
    init {
        viewModelScope.launch {
            //1. Cargamos la lista de la clase Datos
            val pizzasAInsertar = Datos().loadPizzas()
            //2. Los insertamos en un ciclo forEach
            pizzasAInsertar.forEach { pizza ->
                pizzaDAO.insert(pizza)
            }
        }
    }

    fun actualizarPizza(pizzaEditada: Pizza){
        viewModelScope.launch {
            pizzaDAO.update(pizzaEditada)
        }
    }

    fun getPizzaById(id: Int): Pizza?{
        return pizzaList.value.find { it.id == id }
    }
}