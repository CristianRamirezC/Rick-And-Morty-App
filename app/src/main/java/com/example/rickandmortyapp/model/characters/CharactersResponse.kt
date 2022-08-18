package com.example.rickandmortyapp.model.characters

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") var responseInfo: Info?,
    @SerializedName("results") var responseResults: List<Results>

)
