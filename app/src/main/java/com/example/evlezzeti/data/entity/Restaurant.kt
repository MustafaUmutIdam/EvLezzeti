package com.example.evlezzeti.data.entity

data class Restaurant(
    val id: Int,
    val name: String,
    val distance: String,
    val imageUrl: String? = null,
    var isFavorite: Boolean = false
) 