package com.example.evlezzeti.data.datasource

import androidx.lifecycle.MutableLiveData
import com.example.evlezzeti.data.entity.Kullanici

class FirestoreDataSource {

    var kullanici = MutableLiveData<Kullanici>()

    fun kullaniciGirisKontrol(ePosta:String, sifre:String): Boolean {

        var dogruEPosta = "merhaba@evlezzeti.com"
        var dogruSifre = "123456789"

        return ePosta == dogruEPosta && sifre==dogruSifre
    }


}