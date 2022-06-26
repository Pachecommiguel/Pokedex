package com.example.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.paging.PokemonPagingSource
import com.example.data.responses.PokemonListItem
import com.example.data.responses.generated.PokemonResponse
import com.example.data.webservices.PokemonWebservice
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImp @Inject constructor(
    private val webservice: PokemonWebservice,
    private val pokemonPagingSource: PokemonPagingSource
) : PokemonRepository {
    private var pokemonMap = mutableMapOf<Int, PokemonResponse>()

    override suspend fun get(url: String?) = webservice.get(url).also {
        pokemonMap[it.id] = it
    }

    override fun getNext() = Pager(
        config = PagingConfig(1),
        pagingSourceFactory = { pokemonPagingSource }
    ).flow

    override fun getById(id: Int) = pokemonMap[id]
}

interface PokemonRepository {
    suspend fun get(url: String?): PokemonResponse
    fun getNext(): Flow<PagingData<PokemonListItem>>
    fun getById(id: Int): PokemonResponse?
}