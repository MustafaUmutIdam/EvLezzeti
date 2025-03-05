package com.example.evlezzeti.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.evlezzeti.data.entity.Kullanici
import com.example.evlezzeti.data.entity.Mutfak
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FirestoreDataSource (var collection: CollectionReference) {

    var kullanici = MutableLiveData<Kullanici>()
    var mutfakListe = MutableLiveData<List<Mutfak>>()

    fun kullaniciGirisKontrol(ePosta:String, sifre:String): Boolean {

        var dogruEPosta = "merhaba@evlezzeti.com"
        var dogruSifre = "1"

        return ePosta == dogruEPosta && sifre==dogruSifre
    }
    
     fun mutfakYukle() : MutableLiveData<List<Mutfak>>{ // Mutfak listesinin dondugu yer
         collection.addSnapshotListener { value, error ->
             if (value !=null ){
                 val liste = ArrayList<Mutfak>()

                 for (m in value.documents){
                     val mutfak = m.toObject(Mutfak::class.java)
                     if(mutfak != null) {
                         mutfak.mutfakId = m.id
                         liste.add(mutfak)
                     }
                 }
                 mutfakListe.value = liste
             }
         }
            return mutfakListe
     }
}