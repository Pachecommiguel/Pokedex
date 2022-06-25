package com.example.pokedex.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokedex.databinding.DetailsRecyclerViewItemBinding

class PokemonDetailsViewAdapter
    : ListAdapter<String, PokemonDetailsViewHolder>(PokemonDetailsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PokemonDetailsViewHolder(
        DetailsRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PokemonDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}