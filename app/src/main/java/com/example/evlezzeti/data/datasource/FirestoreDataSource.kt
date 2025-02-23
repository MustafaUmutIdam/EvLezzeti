package com.example.evlezzeti.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.evlezzeti.data.entity.Kullanici
import com.example.evlezzeti.data.entity.Mutfak
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FirestoreDataSource {

    var kullanici = MutableLiveData<Kullanici>()

    fun kullaniciGirisKontrol(ePosta:String, sifre:String): Boolean {

        var dogruEPosta = "merhaba@evlezzeti.com"
        var dogruSifre = "1"

        return ePosta == dogruEPosta && sifre==dogruSifre
    }
    
    suspend fun mutfakYukle() : List<Mutfak> =
        withContext(Dispatchers.IO){

            val mutfakListe = ArrayList<Mutfak>()

            val m1 = Mutfak("0","Aysun Mutfağı","0538 001","38.01 , 10.83","5.0","En Güzel Lezzetler","Develi/Adana","mutfak_resim")
            val m2 = Mutfak("1","Aysun Mutfağı","0538 001","38.01 , 10.83","5.0","En Güzel Lezzetler","Develi/Adana","mutfak_resim")
            val m3 = Mutfak("2","Aysun Mutfağı","0538 001","38.01 , 10.83","5.0","En Güzel Lezzetler","Develi/Adana","mutfak_resim")

            mutfakListe.add(m1)
            mutfakListe.add(m2)
            mutfakListe.add(m3)
            mutfakListe.add(m1)
            mutfakListe.add(m2)
            mutfakListe.add(m3)
            mutfakListe.add(m1)
            mutfakListe.add(m2)
            mutfakListe.add(m3)
            println("dataS Bilgi ${mutfakListe.get(0).mutfakAd} BilgiDataa")
            return@withContext mutfakListe
        }
}