package com.example.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.states.Pokemon
import com.example.domain.usecases.MainUseCase
import com.example.pokedex.fragments.MainFragmentDirections
import com.example.pokedex.fragments.OnPokemonClickListener
import com.example.pokedex.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel(), OnPokemonClickListener {

    private val navDirection: SingleLiveEvent<NavDirections> = SingleLiveEvent()

    override fun onPokemonClick(id: Int?) {
        id?.let { navDirection.value = MainFragmentDirections.actionMainToDetails(it) }
    }

    fun getNavDirection(): LiveData<NavDirections> = navDirection

    fun getState(): Flow<PagingData<Pokemon>> = useCase().cachedIn(viewModelScope)
}