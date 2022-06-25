package com.example.pokedex.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.states.MainState
import com.example.pokedex.R
import com.example.pokedex.databinding.MainRecyclerViewItemBinding
import com.example.pokedex.fragments.OnPokemonClickListener

class MainViewAdapter(
    private val listener: OnPokemonClickListener
) : PagingDataAdapter<MainState, MainViewAdapter.MainViewHolder>(MainDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        MainRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
        if (position == 0) listener.onPokemon()
    }

    inner class MainViewHolder(
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
}

class MainDiffCallback : DiffUtil.ItemCallback<MainState>() {

    override fun areItemsTheSame(oldItem: MainState, newItem: MainState) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MainState, newItem: MainState) = oldItem == newItem
}
