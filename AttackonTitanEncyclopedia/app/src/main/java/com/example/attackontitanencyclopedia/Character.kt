package com.example.attackontitanencyclopedia

import androidx.annotation.DrawableRes

data class Character(
    val name: String,
    @DrawableRes val imageResId: Int
)