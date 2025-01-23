package com.example.evlezzeti.data.repo

import com.example.evlezzeti.data.datasource.FirestoreDataSource

class Repository(var fds:FirestoreDataSource) {

    fun kullaniciGirisKontrol(ePosta:String, sifre:String) : Boolean = fds.kullaniciGirisKontrol(ePosta,sifre)

}