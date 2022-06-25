package com.example.pokedex.recycler

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.states.Pokemon
import com.example.pokedex.databinding.RecyclerViewItemBinding
import com.example.pokedex.fragments.OnPokemonClickListener

class PokemonViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon, listener: OnPokemonClickListener) {
        binding.pokemon = pokemon
        binding.layout.setOnClickListener { listener.onPokemonClick(pokemon.id) }
        Glide.with(context)
            .load(pokemon.image)
            .into(binding.image)
    }
}