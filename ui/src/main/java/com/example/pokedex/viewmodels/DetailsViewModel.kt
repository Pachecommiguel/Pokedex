package com.example.pokedex.viewmodels

import androidx.lifecycle.*
import com.example.domain.states.DetailsState
import com.example.domain.usecases.DetailsUseCase
import com.example.pokedex.fragments.DetailsFragmentArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: DetailsUseCase
) : ViewModel() {

    lateinit var args: DetailsFragmentArgs
    val state: LiveData<DetailsState> = liveData {
        emit(useCase(args.id))
    }
}