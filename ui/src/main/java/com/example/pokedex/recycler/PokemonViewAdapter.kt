package com.example.pokedex.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.domain.states.MainState
import com.example.pokedex.databinding.MainRecyclerViewItemBinding
import com.example.pokedex.fragments.OnPokemonClickListener

class PokemonViewAdapter(
    private val listener: OnPokemonClickListener
) : PagingDataAdapter<MainState, PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PokemonViewHolder(
        MainRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}