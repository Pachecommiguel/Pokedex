package com.example.pokedex.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.states.MainState

class PokemonDiffCallback : DiffUtil.ItemCallback<MainState>() {

    override fun areItemsTheSame(oldItem: MainState, newItem: MainState) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MainState, newItem: MainState) = oldItem == newItem
}