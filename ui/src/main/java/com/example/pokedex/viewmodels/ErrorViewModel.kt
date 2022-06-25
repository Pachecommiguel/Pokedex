package com.example.pokedex.viewmodels

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.NavDirections
import com.example.domain.states.DialogState
import com.example.domain.usecases.ErrorUseCase
import com.example.pokedex.fragments.ErrorFragmentArgs
import com.example.pokedex.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ErrorViewModel @Inject constructor(
    private val useCase: ErrorUseCase
) : ViewModel() {

    lateinit var args: ErrorFragmentArgs
    private val navDirection: SingleLiveEvent<NavDirections> = SingleLiveEvent()
    val state: LiveData<DialogState> = liveData {
        emit(useCase())
    }

    fun getNavDirection(): LiveData<NavDirections> = navDirection

    @Suppress("UNUSED_PARAMETER")
    fun onButtonClick(view: View) {
        navDirection.value = ACTION_NAVIGATE_UP
        args.listener.onRetryButtonClick()
    }
}