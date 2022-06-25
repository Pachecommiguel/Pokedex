package com.example.pokedex.recycler

import androidx.recyclerview.widget.DiffUtil

class PokemonDetailsDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
}