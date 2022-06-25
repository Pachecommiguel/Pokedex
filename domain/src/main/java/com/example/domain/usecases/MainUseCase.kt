package com.example.domain.usecases

import com.example.data.repositories.PokemonRepository
import com.example.data.responses.generated.PokemonResponse
import com.example.domain.R
import com.example.domain.application.App
import com.example.domain.states.MainState
import com.example.domain.states.MainStateResult
import com.example.domain.states.Pokemon
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke() = try {
        repository.getAll().results?.map {
            repository.get(it.url).toPokemon()
        }?.let {
            MainStateResult.Success(MainState(it))
        } ?: MainStateResult.Error()
    } catch (e: Exception) {
        MainStateResult.Error()
    }
}

private fun PokemonResponse.toPokemon() = Pokemon(
    this.id,
    this.name?.replaceFirstChar(Char::uppercase) ?: App.resources.getString(R.string.pokemon_default_name),
    this.sprites?.other?.officialArtwork?.frontDefault
)