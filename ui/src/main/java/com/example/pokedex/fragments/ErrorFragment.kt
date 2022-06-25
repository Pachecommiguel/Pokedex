package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.domain.states.ErrorState
import com.example.pokedex.databinding.FragmentErrorBinding
import com.example.pokedex.viewmodels.ACTION_NAVIGATE_UP
import com.example.pokedex.viewmodels.ErrorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ErrorFragment : AbstractDialogFragment() {

    private lateinit var binding: FragmentErrorBinding
    private val viewModel: ErrorViewModel by viewModels()
    private val args: ErrorFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentErrorBinding.inflate(inflater, container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.args = args
        viewModel.getNavDirection().observe(viewLifecycleOwner, ::onNavDirection)
        viewModel.state.observe(viewLifecycleOwner, ::onState)
        binding.button.setOnClickListener(viewModel::onClickListener)
    }

    private fun onState(state: ErrorState) {
        binding.state = state
    }

    private fun onNavDirection(direction: NavDirections) {
        if (direction == ACTION_NAVIGATE_UP) {
            findNavController().navigateUp()
        }
    }
}