package com.example.domain.states

data class DetailsState(
    val name: String,
    val image: String?,
    val height: String,
    val weight: String,
    val moves: List<String>,
    val labels: Labels
)

data class Labels(
    val name: String,
    val height: String,
    val weight: String,
    val moves: String
)