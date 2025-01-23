package com.example.evlezzeti.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.evlezzeti.R
import com.example.evlezzeti.databinding.FragmentGirisYapBinding
import com.example.evlezzeti.ui.viewmodel.GirisYapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GirisYapFragment : Fragment() {
    private lateinit var binding : FragmentGirisYapBinding
    private lateinit var viewModel: GirisYapViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View{
        binding = FragmentGirisYapBinding.inflate(inflater, container, false)

        //Animasyon icin
        binding.lottieAnimationView.setAnimation(R.raw.giris_gif_json)
        binding.lottieAnimationView.playAnimation()

        //Kullanici Giris Yapma Kontrolu
        binding.girisYapButton.setOnClickListener{
            val ePosta = binding.ePostaEditText.text.toString()
            val sifre = binding.sifreEditText.text.toString()

            if (ePosta.isEmpty() || sifre.isEmpty()){
                Toast.makeText(requireContext(), "Lütfen tüm alanları doldurun!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            else {
                val durum = viewModel.kullaniciGirisKontrol(ePosta,sifre)
                Toast.makeText(requireContext(), durum, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

        }

        return binding.root
    }

    //Direk viewmodel Kullanamadigimiz icin burası sart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: GirisYapViewModel by viewModels()
        viewModel = tempViewModel
    }

}