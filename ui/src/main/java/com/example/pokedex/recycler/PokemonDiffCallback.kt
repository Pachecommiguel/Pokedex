package com.example.pokedex.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.states.Pokemon

class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem == newItem
}