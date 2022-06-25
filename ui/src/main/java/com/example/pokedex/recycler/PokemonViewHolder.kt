package com.example.pokedex.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.states.Pokemon
import com.example.pokedex.R
import com.example.pokedex.databinding.MainRecyclerViewItemBinding
import com.example.pokedex.fragments.OnPokemonClickListener

class PokemonViewHolder(
    private val binding: MainRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon?, listener: OnPokemonClickListener) {
        binding.pokemon = pokemon
        binding.layout.setOnClickListener { listener.onPokemonClick(pokemon?.id) }
        Glide.with(binding.root)
            .load(pokemon?.image)
            .placeholder(R.drawable.pokeball)
            .error(R.drawable.pokeball)
            .into(binding.image)
    }
}