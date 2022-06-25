package com.example.pokedex.viewmodels

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.example.domain.states.MainState
import com.example.domain.states.MainStateResult
import com.example.domain.usecases.MainUseCase
import com.example.pokedex.fragments.LoadingFragmentDirections
import com.example.pokedex.fragments.MainFragmentDirections
import com.example.pokedex.fragments.OnPokemonClickListener
import com.example.pokedex.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel(), OnErrorClickListener, OnPokemonClickListener {

    private val navDirection: SingleLiveEvent<NavDirections> = SingleLiveEvent()
    val state: MutableLiveData<MainState> = liveData {
        getState()?.let { emit(it) }
    } as MutableLiveData<MainState>

    fun getNavDirection(): LiveData<NavDirections> = navDirection

    override fun onClick() {
        viewModelScope.launch {
            getState()?.let { state.value = it }
        }
    }

    override fun onPokemonClick(id: Int) {
        navDirection.value = MainFragmentDirections.actionMainToDetails(id)
    }

    private suspend fun getState(): MainState? {
        navDirection.value = MainFragmentDirections.actionMainToLoading()
        val result = useCase()
        navDirection.value = when(result) {
            is MainStateResult.Success -> ACTION_NAVIGATE_UP
            is MainStateResult.Error -> LoadingFragmentDirections.actionLoadingToError(
                this@MainViewModel,
                result.message
            )
        }

        return (result as? MainStateResult.Success)?.state
    }
}

interface OnErrorClickListener : Serializable {
    fun onClick()
}

val ACTION_NAVIGATE_UP = object : NavDirections {
    override val actionId = -1
    override val arguments: Bundle = Bundle.EMPTY
}