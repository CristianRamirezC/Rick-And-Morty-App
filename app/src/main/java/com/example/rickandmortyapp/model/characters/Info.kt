package com.example.rickandmortyapp.model.characters

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count") var totalCharacters: Int,
    @SerializedName("pages") var numberOfPages: Int,
    @SerializedName("next") var nextPage: String?,
    @SerializedName("prev") var previousPage: String?
)
