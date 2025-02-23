package com.example.evlezzeti.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.evlezzeti.data.entity.Mutfak
import com.example.evlezzeti.data.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomNavMenuViewModel @Inject constructor (var rep : Repository): ViewModel(){
    var mutfakListe = MutableLiveData<List<Mutfak>>()

    init {
        mutfakYukle()
    }

    private fun mutfakYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            mutfakListe.value= rep.mutfakYukle()
        }
    }
}