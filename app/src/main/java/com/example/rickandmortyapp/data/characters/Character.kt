package com.example.rickandmortyapp.data.characters

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id") var characterId: Int?,
    @SerializedName("name") var characterName: String,
    @SerializedName("status") var characterStatus: String,
    @SerializedName("species") var characterSpecies: String,
    @SerializedName("type") var characterType: String,
    @SerializedName("gender") var characterGender: String,
    @SerializedName("origin") var characterOrigin: Location,
    @SerializedName("location") var characterLocation: Location,
    @SerializedName("image") var characterImage: String,
    @SerializedName("episode") var characterEpisode: List<String>,
    @SerializedName("url") var characterUrl: String,
    @SerializedName("created") var characterCreatedAt: String
)
