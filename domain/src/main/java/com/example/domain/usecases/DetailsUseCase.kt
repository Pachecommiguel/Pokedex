package com.example.domain.usecases

import com.example.data.repositories.PokemonRepository
import com.example.domain.states.DetailsState
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(id: Int): DetailsState {
        val result = repository.getById(id)
        return DetailsState(
            result?.name,
            result?.sprites?.other?.officialArtwork?.frontDefault
        )
    }
}