package com.example.rickandmortyapp.model.characters

import com.google.gson.annotations.SerializedName

data class CharactersInfo(
    @SerializedName("count") var totalCharacters: Int = 0,
    @SerializedName("pages") var numberOfPages: Int =0,
    @SerializedName("next") var nextPage: String? = "",
    @SerializedName("prev") var previousPage: String? = ""
)
