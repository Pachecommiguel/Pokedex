package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.pokedex.adapters.MainLoadStateAdapter
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.adapters.MainViewAdapter
import com.example.pokedex.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var adapter: MainViewAdapter
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setViewModel()
    }

    private fun setViewModel() {
        viewModel.getNavDirection().observe(viewLifecycleOwner, ::onNavDirection)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getState().collectLatest(adapter::submitData)
        }
    }

    private fun setAdapter() {
        adapter = MainViewAdapter(viewModel)
        binding.recyclerView.adapter = adapter.withLoadStateFooter(
            MainLoadStateAdapter(adapter::retry)
        )
    }

    private fun onNavDirection(direction: NavDirections) {
        findNavController().navigate(direction)
    }
}

interface OnPokemonClickListener {
    fun onPokemonClick(id: Int?)
}