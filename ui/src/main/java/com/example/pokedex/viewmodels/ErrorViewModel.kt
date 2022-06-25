package com.example.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.states.ErrorState
import com.example.domain.usecases.ErrorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ErrorViewModel @Inject constructor(
    private val useCase: ErrorUseCase
) : ViewModel() {

    val state: LiveData<ErrorState> = liveData {
        emit(useCase())
    }
}