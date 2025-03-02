package com.example.evlezzeti.ui.fragment.girissayfasi

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.evlezzeti.R
import com.example.evlezzeti.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {
    private val splashScreenDuration = 6000L // 8 saniye
    private lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        val animation1 = android.view.animation.AnimationUtils.loadAnimation(requireContext(), R.anim.animation_splash1)
        val animation2 = android.view.animation.AnimationUtils.loadAnimation(requireContext(), R.anim.animation_splash2)

        // ImageView'lara animasyonları ata
        binding.splashImageGri.startAnimation(animation1)
        binding.splashImageRenkli.startAnimation(animation2)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.onBoard1Fragment)
        }, splashScreenDuration)

        return binding.root
    }

}