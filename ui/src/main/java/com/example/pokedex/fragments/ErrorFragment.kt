package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.domain.states.ErrorState
import com.example.pokedex.databinding.FragmentErrorBinding
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
        viewModel.state.observe(viewLifecycleOwner, ::onState)
        binding.button.setOnClickListener {
            findNavController().navigateUp()
            args.listener.onClick()
        }
    }

    private fun onState(state: ErrorState) {
        binding.state = state
    }
}