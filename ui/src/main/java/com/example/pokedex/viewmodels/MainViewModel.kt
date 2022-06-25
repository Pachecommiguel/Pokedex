package com.example.pokedex.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.NavDirections
import com.example.domain.states.MainState
import com.example.domain.states.MainStateResult
import com.example.domain.usecases.MainUseCase
import com.example.pokedex.fragments.MainFragmentDirections
import com.example.pokedex.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private val navDirection: SingleLiveEvent<NavDirections> = SingleLiveEvent()
    val state: LiveData<MainState> = liveData {
        navDirection.value = MainFragmentDirections.actionMainToLoading()
        when(val result = useCase()) {
            is MainStateResult.Success -> {
                emit(result.state)
                navDirection.value = ACTION_NAVIGATE_UP
            }
            is MainStateResult.Error -> TODO()
        }
    }

    fun getNavDirection(): LiveData<NavDirections> = navDirection
}

val ACTION_NAVIGATE_UP = object : NavDirections {
    override val actionId = -1
    override val arguments: Bundle = Bundle.EMPTY
}