package com.example.evlezzeti.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evlezzeti.adapter.RestaurantAdapter
import com.example.evlezzeti.data.entity.Restaurant
import com.example.evlezzeti.databinding.FragmentBottomNavMenuBinding

class BottomNavMenuFragment : Fragment() {
    private lateinit var binding: FragmentBottomNavMenuBinding
    private val restaurantAdapter = RestaurantAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomNavMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSearchView()
        loadSampleData()
    }

    private fun setupRecyclerView() {
        binding.restaurantRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = restaurantAdapter
        }
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { restaurantAdapter.filter(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { restaurantAdapter.filter(it) }
                return true
            }
        })
    }

    private fun loadSampleData() {
        val sampleRestaurants = listOf(
            Restaurant(
                id = 1,
                name = "Ayşe Teyze'nin Yeri",
                distance = "1.2 km uzaklıkta"
            ),
            Restaurant(
                id = 2,
                name = "Anadolu Lezzetleri",
                distance = "2.5 km uzaklıkta"
            ),
            Restaurant(
                id = 3,
                name = "Osmanlı Mutfağı",
                distance = "0.8 km uzaklıkta"
            ),
            Restaurant(
                id = 4,
                name = "Ev Yemekleri Dünyası",
                distance = "3.1 km uzaklıkta"
            ),
            Restaurant(
                id = 5,
                name = "Lezzet Durağı",
                distance = "1.7 km uzaklıkta"
            ),
            Restaurant(
                id = 6,
                name = "Geleneksel Tatlar",
                distance = "2.3 km uzaklıkta"
            ),
            Restaurant(
                id = 7,
                name = "Yöresel Mutfak",
                distance = "1.5 km uzaklıkta"
            )
        )
        restaurantAdapter.setRestaurants(sampleRestaurants)
    }
}