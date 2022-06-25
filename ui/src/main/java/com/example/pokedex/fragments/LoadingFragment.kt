package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.domain.states.LoadingState
import com.example.pokedex.databinding.FragmentLoadingBinding
import com.example.pokedex.viewmodels.LoadingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadingFragment : AbstractDialogFragment() {

    private lateinit var binding: FragmentLoadingBinding
    private val viewModel: LoadingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentLoadingBinding.inflate(inflater, container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, ::onState)
    }

    private fun onState(state: LoadingState) {
        binding.state = state
    }
}