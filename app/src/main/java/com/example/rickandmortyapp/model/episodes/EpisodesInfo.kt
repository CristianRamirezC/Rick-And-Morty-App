package com.example.rickandmortyapp.model.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesInfo(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("pages") var pages: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("prev") var prev: String? = null
)