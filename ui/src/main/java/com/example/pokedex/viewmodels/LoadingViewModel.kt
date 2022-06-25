package com.example.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.states.DialogState
import com.example.domain.usecases.LoadingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val useCase: LoadingUseCase
) : ViewModel() {

    val state: LiveData<DialogState> = liveData {
        emit(useCase())
    }
}