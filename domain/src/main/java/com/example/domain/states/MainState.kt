package com.example.domain.states

sealed class MainState {
    data class Success(val pokemonList: List<Pokemon>) : MainState()
    data class Error(val message: String? = null) : MainState()
}

data class Pokemon(
    val name: String
)
