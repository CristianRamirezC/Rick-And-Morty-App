package com.example.rickandmortyapp.model.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesResponse(

    @SerializedName("info") var info: EpisodesInfo? = EpisodesInfo(),
    @SerializedName("results") var episodesList: List<Episode> = listOf<Episode>()

)