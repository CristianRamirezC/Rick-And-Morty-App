package com.example.rickandmortyapp.model.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesInfo(
    @SerializedName("count") var totalEpisodes: Int? = 0,
    @SerializedName("pages") var numberOfPages: Int? = 0,
    @SerializedName("next") var nextPage: String? = "",
    @SerializedName("prev") var previousPage: String? = ""
)