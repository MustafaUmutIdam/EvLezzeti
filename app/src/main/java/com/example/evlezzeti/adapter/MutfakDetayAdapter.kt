package com.example.evlezzeti.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.evlezzeti.data.entity.Yemek
import com.example.evlezzeti.databinding.ItemMutfakDetayBinding
import com.bumptech.glide.Glide

class MutfakDetayAdapter : ListAdapter<Yemek, MutfakDetayAdapter.MutfakDetayViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MutfakDetayViewHolder {
        val binding = ItemMutfakDetayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MutfakDetayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MutfakDetayViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class MutfakDetayViewHolder(private val binding: ItemMutfakDetayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(yemek: Yemek) {
            binding.apply {
                tvYemekAdi.text = yemek.ad
                tvYemekFiyat.text = "${yemek.fiyat} ₺"
                tvYemekAciklama.text = yemek.aciklama
                
                Glide.with(itemView)
                    .load(yemek.resimUrl)
                    .into(ivYemekResim)
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Yemek>() {
        override fun areItemsTheSame(oldItem: Yemek, newItem: Yemek) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Yemek, newItem: Yemek) =
            oldItem == newItem
    }
} 