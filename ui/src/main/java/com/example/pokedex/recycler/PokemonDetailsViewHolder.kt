package com.example.pokedex.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.DetailsRecyclerViewItemBinding

class PokemonDetailsViewHolder(
    private val binding: DetailsRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ability: String) {
        binding.ability.text = ability
    }
}