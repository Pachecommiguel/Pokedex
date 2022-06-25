package com.example.domain.states

sealed class MainStateResult {
    data class Success(val state: MainState) : MainStateResult()
    data class Error(val message: Int) : MainStateResult()
}

data class MainState(
    val pokemonList: List<Pokemon>
)

data class Pokemon(
    val id: Int,
    val name: String,
    val image: String?
)
