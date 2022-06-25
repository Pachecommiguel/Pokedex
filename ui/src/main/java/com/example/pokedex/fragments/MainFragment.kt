package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.domain.states.MainState
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.recycler.PokemonViewAdapter
import com.example.pokedex.viewmodels.ACTION_NAVIGATE_UP
import com.example.pokedex.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var adapter: PokemonViewAdapter

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        viewModel.getNavDirection().observe(viewLifecycleOwner, ::onNavDirection)
        viewModel.state.observe(viewLifecycleOwner, ::onState)
    }

    private fun onState(state: MainState) {
        adapter.submitList(state.pokemonList)
    }

    private fun onNavDirection(direction: NavDirections) {
        when(direction) {
            ACTION_NAVIGATE_UP -> findNavController().navigateUp()
            else -> findNavController().navigate(direction)
        }
    }
}