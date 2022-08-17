package com.example.rickandmortyapp.model

data class Character(
    val characterID: Int,
    val characterName: String,
    val characterStatus: String,
    val characterImage: String,
    val characterGender: String,
    val characterOrigin: String,
    val characterSpecies: String,
)
