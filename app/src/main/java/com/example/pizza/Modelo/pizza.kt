package com.example.pizza.Modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class pizza(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
