package com.example.pokedex.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.LoadStateItemBinding

class MainLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<MainLoadStateAdapter.MainLoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = MainLoadStateViewHolder(
        LoadStateItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), retry
    )

    override fun onBindViewHolder(
        holder: MainLoadStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)

    inner class MainLoadStateViewHolder(
        private val binding: LoadStateItemBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.button.setOnClickListener { retry() }
        }

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.error.text = loadState.error.localizedMessage
            }

            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.button.isVisible = loadState is LoadState.Error
            binding.error.isVisible = loadState is LoadState.Error
        }
    }
}