package com.example.rickandmortyapp.model.episodes

import com.google.gson.annotations.SerializedName

data class Episode(

    @SerializedName("id") var episodeId: Int? = null,
    @SerializedName("name") var episodeName: String? = null,
    @SerializedName("air_date") var episodeAirDate: String? = null,
    @SerializedName("episode") var episodeCode: String? = null,
    @SerializedName("characters") var episodeCharacters: ArrayList<String> = arrayListOf(),
    @SerializedName("url") var episodeUrl: String? = null,
    @SerializedName("created") var episodeCreatedAt: String? = null

)