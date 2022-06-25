package com.example.data.webservices

import com.example.data.responses.PokemonListResponse
import com.example.data.utils.Endpoints
import com.example.data.responses.generated.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonWebservice {

    @GET(Endpoints.POKEMON)
    suspend fun getList() : PokemonListResponse

    @GET
    suspend fun getNext(@Url url: String?) : PokemonListResponse

    @GET
    suspend fun get(@Url url: String?) : PokemonResponse
}