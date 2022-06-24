package com.example.domain.usecases

import com.example.data.repositories.PokemonRepository
import com.example.domain.states.MainState
import com.example.domain.states.Pokemon
import java.lang.Exception
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke() = try {
        MainState.Success(
            repository.getAll().results.map {
                Pokemon(
                    it.name,
                    repository.get(it.url).sprites?.other?.officialArtwork?.frontDefault
                )
            }
        )
    } catch (e: Exception) {
        MainState.Error()
    }
}