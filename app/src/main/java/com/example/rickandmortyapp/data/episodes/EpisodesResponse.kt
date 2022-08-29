package com.example.rickandmortyapp.data.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesResponse(

    @SerializedName("info") var episodesInfo: EpisodesInfo? = EpisodesInfo(),
    @SerializedName("results") var episodesList: List<Episode> = emptyList()

)