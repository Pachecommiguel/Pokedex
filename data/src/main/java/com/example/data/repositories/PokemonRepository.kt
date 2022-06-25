package com.example.data.repositories

import com.example.data.responses.generated.PokemonResponse
import com.example.data.webservices.PokemonWebservice
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val webservice: PokemonWebservice
) {
    private var pokemonMap = mutableMapOf<Int, PokemonResponse>()

    suspend fun getAll() = webservice.getList()

    suspend fun get(url: String?) = webservice.get(url).also {
        pokemonMap[it.id] = it
    }

    fun getById(id: Int) = pokemonMap[id]
}