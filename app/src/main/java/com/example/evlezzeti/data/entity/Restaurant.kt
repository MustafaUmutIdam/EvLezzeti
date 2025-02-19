package com.example.evlezzeti.data.entity

import java.io.Serializable

data class Restaurant(
    val id: Int,
    val name: String,
    val distance: String,
    var isFavorite: Boolean,
    val imageResId: Int? = null // String yerine Int kullanıyoruz
): Serializable

