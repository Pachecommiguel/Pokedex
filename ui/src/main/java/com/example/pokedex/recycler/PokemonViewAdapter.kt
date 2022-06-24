package com.example.pokedex.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.states.Pokemon
import com.example.pokedex.databinding.RecyclerViewItemBinding
import javax.inject.Inject

class PokemonViewAdapter @Inject constructor(

) : ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PokemonViewHolder(
        RecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), parent.context
    )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}