package com.example.rickandmortyapp.model.episodes

import com.example.rickandmortyapp.model.characters.Character

data class Episode(
    val episodeID: Int,
    val episodeName: String,
    val episodeAirDate: String,
    val episodeCode: String,
    val episodeCharacters: List<Character>
)
