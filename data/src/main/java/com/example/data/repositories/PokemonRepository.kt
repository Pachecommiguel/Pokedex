package com.example.data.repositories

import com.example.data.webservices.PokemonWebservice
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val webservice: PokemonWebservice
) {
    suspend fun getAll() = webservice.getPokemonList()
}