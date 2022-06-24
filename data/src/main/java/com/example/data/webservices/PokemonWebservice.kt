package com.example.data.webservices

import com.example.data.responses.PokemonListResponse
import com.example.data.utils.Endpoints
import retrofit2.http.GET

interface PokemonWebservice {

    @GET(Endpoints.POKEMON)
    suspend fun getPokemonList() : PokemonListResponse
}