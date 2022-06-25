package com.example.pokedex.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.DetailsRecyclerViewItemBinding

class DetailsViewAdapter
    : ListAdapter<String, DetailsViewAdapter.DetailsViewHolder>(DetailsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DetailsViewHolder(
        DetailsRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DetailsViewHolder(
        private val binding: DetailsRecyclerViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ability: String) {
            binding.ability.text = ability
        }
    }
}

class DetailsDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
}