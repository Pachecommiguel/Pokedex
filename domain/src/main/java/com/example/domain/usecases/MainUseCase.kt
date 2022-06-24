package com.example.domain.usecases

import com.example.data.repositories.PokemonRepository
import com.example.domain.states.MainState
import com.example.domain.states.MainStateResult
import com.example.domain.states.Pokemon
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke() = try {
        val result = repository.getAll().results.map { item ->
            repository.get(item.url).let {
                Pokemon(
                    it.id,
                    item.name,
                    it.sprites?.other?.officialArtwork?.frontDefault
                )
            }
        }

        MainStateResult.Success(MainState(result))
    } catch (e: Exception) {
        MainStateResult.Error()
    }
}