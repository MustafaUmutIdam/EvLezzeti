package com.example.evlezzeti.data.entity

import java.io.Serializable

data class Yemek(
    val id: Int,
    val ad: String,
    val aciklama: String,
    val fiyat: Double,
    val resimUrl: String
) :Serializable