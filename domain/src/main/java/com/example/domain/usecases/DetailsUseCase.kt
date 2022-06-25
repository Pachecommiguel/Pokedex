package com.example.domain.usecases

import com.example.data.repositories.PokemonRepository
import com.example.data.responses.generated.PokemonResponse
import com.example.domain.R
import com.example.domain.application.App
import com.example.domain.states.DetailsState
import com.example.domain.states.Labels
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(id: Int) = repository.getById(id).toDetailsState()
}

private fun PokemonResponse?.toDetailsState() = DetailsState(
    this?.name?.replaceFirstChar(Char::uppercase) ?: App.resources.getString(R.string.pokemon_default_stat),
    this?.sprites?.other?.officialArtwork?.frontDefault,
    this?.height?.toCM() ?: App.resources.getString(R.string.pokemon_default_height),
    this?.weight?.toKG() ?: App.resources.getString(R.string.pokemon_default_weight),
    this?.moves?.map {
        it.move?.name ?: App.resources.getString(R.string.pokemon_default_stat)
    } ?: listOf(),
    Labels(
        App.resources.getString(R.string.details_name_label),
        App.resources.getString(R.string.details_height_label),
        App.resources.getString(R.string.details_weight_label),
        App.resources.getString(R.string.details_moves_label)
    )
)

private fun Int?.toCM() = this?.times(10).toString() + " cm"

private fun Int?.toKG() = this?.div(10).toString() + " kg"
