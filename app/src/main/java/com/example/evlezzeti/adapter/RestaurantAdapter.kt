package com.example.evlezzeti.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.evlezzeti.R
import com.example.evlezzeti.data.entity.Restaurant
import com.example.evlezzeti.databinding.ItemRestaurantBinding
import com.example.evlezzeti.ui.fragment.BottomNavMenuFragmentDirections

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private var restaurants = listOf<Restaurant>()
    private var filteredRestaurants = listOf<Restaurant>()
    private var onRestaurantClickListener: ((Restaurant) -> Unit)? = null

    // Her restaurant için farklı bir görsel
    private val restaurantImages = listOf(
        R.drawable.ahmet_mutfagi,
        R.drawable.ali_mutfagi,
        R.drawable.gamze_mutfagi,
        R.drawable.mehmet_mutfagi,
        R.drawable.murat_mutfagi,
        R.drawable.ozlem_mutfagi,
        R.drawable.yusuf_mutfagi
    )

    fun setOnRestaurantClickListener(listener: (Restaurant) -> Unit) {
        onRestaurantClickListener = listener
    }

    fun setRestaurants(newRestaurants: List<Restaurant>) {
        restaurants = newRestaurants.mapIndexed { index, restaurant ->
            restaurant.copy(imageResId = restaurantImages[index % restaurantImages.size])
        }
        filteredRestaurants = restaurants
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        filteredRestaurants = if (query.isEmpty()) {
            restaurants
        } else {
            restaurants.filter { restaurant ->
                restaurant.name.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = filteredRestaurants[position]
        holder.bind(restaurant)

        // CardView'a tıklama işlemi eklendi
        holder.itemView.setOnClickListener {
            val gecis = BottomNavMenuFragmentDirections.restaurantDetayGecis(restaurant)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount() = filteredRestaurants.size

    inner class RestaurantViewHolder(
        private val binding: ItemRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {
            binding.apply {
                restaurantName.text = restaurant.name
                restaurantDistance.text = restaurant.distance
                favoriteButton.isSelected = restaurant.isFavorite

                // Restaurant görselini yükle
                restaurant.imageResId?.let { imageResId ->
                    restaurantImage.setImageResource(imageResId)
                }
                // Favori butonuna tıklama
                favoriteButton.setOnClickListener {
                    restaurant.isFavorite = !restaurant.isFavorite
                    it.isSelected = restaurant.isFavorite
                }
            }
        }
    }
}
