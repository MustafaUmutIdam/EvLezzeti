package com.example.evlezzeti.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evlezzeti.adapter.MutfakDetayAdapter
import com.example.evlezzeti.databinding.FragmentMutfakDetayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MutfakDetayFragment : Fragment() {
    
    private var _binding: FragmentMutfakDetayBinding? = null
    private val binding get() = _binding!!
    private lateinit var mutfakDetayAdapter: MutfakDetayAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMutfakDetayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mutfakDetayAdapter = MutfakDetayAdapter()
        binding.rvMutfakDetay.apply {
            adapter = mutfakDetayAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}