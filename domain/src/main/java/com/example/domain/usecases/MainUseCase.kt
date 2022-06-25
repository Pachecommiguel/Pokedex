package com.example.domain.usecases

import androidx.paging.map
import com.example.data.repositories.PokemonRepository
import com.example.data.responses.generated.PokemonResponse
import com.example.domain.R
import com.example.domain.application.App
import com.example.domain.states.MainState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke() = repository.getNext().mapLatest {
        it.map { item ->
            repository.get(item.url).toMainState()
        }
    }
}

private fun PokemonResponse.toMainState() = MainState(
    this.id,
    this.name?.replaceFirstChar(Char::uppercase) ?: App.resources.getString(R.string.pokemon_default_stat),
    this.sprites?.other?.officialArtwork?.frontDefault
)