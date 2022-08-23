package com.example.rickandmortyapp.model.characters

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") var charactersInfo: CharactersInfo?,
    @SerializedName("results") var responseCharacters: List<Character> = emptyList()

)
