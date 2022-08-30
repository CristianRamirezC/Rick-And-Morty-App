package com.example.rickandmortyapp.data.characters

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") var charactersInfo: CharactersInfo? = CharactersInfo(),
    @SerializedName("results") var responseCharacters: List<Character> = emptyList()
)
