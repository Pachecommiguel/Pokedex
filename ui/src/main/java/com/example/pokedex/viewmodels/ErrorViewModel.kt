package com.example.pokedex.viewmodels

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.domain.states.ErrorState
import com.example.domain.usecases.ErrorUseCase
import com.example.pokedex.fragments.ErrorFragmentArgs
import com.example.pokedex.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ErrorViewModel @Inject constructor(
    private val useCase: ErrorUseCase
) : ViewModel() {

    private val navDirection: SingleLiveEvent<NavDirections> = SingleLiveEvent()
    lateinit var args: ErrorFragmentArgs
    val state: LiveData<ErrorState> = liveData {
        emit(useCase(args.message))
    }

    fun getNavDirection(): LiveData<NavDirections> = navDirection

    fun onClickListener(view: View) {
        navDirection.value = ACTION_NAVIGATE_UP
        args.listener.onClick()
    }
}