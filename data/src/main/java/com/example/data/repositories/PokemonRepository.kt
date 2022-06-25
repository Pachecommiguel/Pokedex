package com.example.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.data.paging.PokemonPagingSource
import com.example.data.responses.generated.PokemonResponse
import com.example.data.webservices.PokemonWebservice
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val webservice: PokemonWebservice,
    private val pokemonPagingSource: PokemonPagingSource
) {
    private var pokemonMap = mutableMapOf<Int, PokemonResponse>()

    suspend fun get(url: String?) = webservice.get(url).also {
        pokemonMap[it.id] = it
    }

    fun getNext() = Pager(
        config = PagingConfig(1),
        pagingSourceFactory = { pokemonPagingSource }
    ).flow

    fun getById(id: Int) = pokemonMap[id]
}