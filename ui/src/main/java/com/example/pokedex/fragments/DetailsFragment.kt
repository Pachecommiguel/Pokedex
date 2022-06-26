package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.domain.states.DetailsState
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentDetailsBinding
import com.example.pokedex.adapters.DetailsViewAdapter
import com.example.pokedex.viewmodels.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var adapter: DetailsViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailsBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = DetailsViewAdapter().also {
            binding.detailsRecyclerView.adapter = it
        }
        viewModel.args = args
        viewModel.state.observe(viewLifecycleOwner, ::onState)
    }

    private fun onState(state: DetailsState) {
        binding.state = state
        if (state.moves.isNotEmpty()) {
            binding.movesLabel.visibility = View.VISIBLE
            adapter.submitList(state.moves)
        }
        Glide.with(requireContext())
            .load(state.image)
            .placeholder(R.drawable.pokeball)
            .error(R.drawable.pokeball)
            .into(binding.image)
    }
}