package com.example.evlezzeti.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.evlezzeti.BottomNavActivity
import com.example.evlezzeti.MainActivity
import com.example.evlezzeti.R
import com.example.evlezzeti.databinding.FragmentBottomNavProfilBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*

class BottomNavProfilFragment : Fragment() {
    private lateinit var binding: FragmentBottomNavProfilBinding
    private lateinit var auth : FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_nav_profil,container,false)
        binding.bottomNavProfilFragment = this
        auth = FirebaseAuth.getInstance()

        binding.buttonCikisYap.setOnClickListener { // Çıkış yapma butonu
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()  // Kullanıcının email adresini al
                .build()

            // Google ile çıkış yap
            val googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

            googleSignInClient.signOut().addOnCompleteListener {
                // Firebase ile de çıkış yap
                FirebaseAuth.getInstance().signOut()
                //auth.currentUser?.delete()
            }
            // Çıkış işlemi tamamlandıktan sonra yapılacak işlemler
            binding.textView2.text = auth.currentUser?.displayName.toString()
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

            // Mevcut activity'i kapat
            requireActivity().finish()
            // Burda  sharedPreferences kullanarak durumları kontrol ettirip splash
            //ekranına gecince duruma göre farklı navigateler kullanılıcak
        }


        return binding.root
    }

}