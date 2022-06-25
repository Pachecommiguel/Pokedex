package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.responses.PokemonListItem
import com.example.data.webservices.PokemonWebservice
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val webservice: PokemonWebservice
): PagingSource<String, PokemonListItem>() {

    override suspend fun load(
        params: LoadParams<String>
    ): LoadResult<String, PokemonListItem> = try {
        val response = params.key?.let {
            webservice.getNext(it)
        } ?: webservice.getList()

        LoadResult.Page(
            data = response.results as List<PokemonListItem>,
            prevKey = response.previous,
            nextKey = response.next
        )
    } catch (e: Exception) {
        LoadResult.Error(e)
    }

    override fun getRefreshKey(state: PagingState<String, PokemonListItem>): String? = null
}