package com.example.domain.usecases

import com.example.data.repositories.PokemonRepository
import com.example.domain.R
import com.example.domain.application.App
import com.example.domain.states.DetailsState
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(id: Int): DetailsState {
        val result = repository.getById(id)
        return DetailsState(
            result?.name ?: App.resources.getString(R.string.pokemon_default_name),
            result?.sprites?.other?.officialArtwork?.frontDefault
        )
    }
}