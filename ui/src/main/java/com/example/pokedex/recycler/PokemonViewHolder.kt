package com.example.pokedex.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.states.MainState
import com.example.pokedex.R
import com.example.pokedex.databinding.MainRecyclerViewItemBinding
import com.example.pokedex.fragments.OnPokemonClickListener

class PokemonViewHolder(
    private val binding: MainRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(state: MainState?, listener: OnPokemonClickListener) {
        binding.state = state
        binding.layout.setOnClickListener { listener.onPokemonClick(state?.id) }
        Glide.with(binding.root)
            .load(state?.image)
            .placeholder(R.drawable.pokeball)
            .error(R.drawable.pokeball)
            .into(binding.image)
    }
}