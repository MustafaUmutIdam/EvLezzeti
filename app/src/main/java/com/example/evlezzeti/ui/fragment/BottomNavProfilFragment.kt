package com.example.evlezzeti.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.evlezzeti.R
import com.example.evlezzeti.databinding.FragmentBottomNavProfilBinding

class BottomNavProfilFragment : Fragment() {
    private lateinit var binding: FragmentBottomNavProfilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_nav_profil,container,false)
        binding.bottomNavProfilFragment = this

        return binding.root
    }
}