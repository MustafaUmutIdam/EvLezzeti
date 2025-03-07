package com.example.evlezzeti.ui.fragment.girissayfasi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.evlezzeti.BottomNavActivity
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

        // Animasyon icin
        binding.lottieAnimationView.setAnimation(R.raw.giris_gif_json)
        binding.lottieAnimationView.playAnimation()


        // Kullanici giris yapma kontrolu
        binding.girisYapButton.setOnClickListener{
            val ePosta = binding.ePostaEditText.text.toString()
            val sifre = binding.sifreEditText.text.toString()

            if (ePosta.isEmpty() || sifre.isEmpty()){
                Toast.makeText(requireContext(), "Lütfen tüm alanları doldurun!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            else {
                val durum = viewModel.kullaniciGirisKontrol(ePosta,sifre)

                // Giris basarili
                if (durum){
                    Navigation.findNavController(it).navigate(R.id.girisYapToBottomNav)
                    val intent = Intent(requireContext(), BottomNavActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

                    startActivity(intent)
                }
                // Giris basarisiz
                else {
                    Toast.makeText(requireContext(), "E-Posta veya şifre Hatalı!!", Toast.LENGTH_LONG).show()
                }
            }
        }

        // EPostaKaydol gecis
        binding.ePostaKaydolButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.girisYapToEPostaKaydol)
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