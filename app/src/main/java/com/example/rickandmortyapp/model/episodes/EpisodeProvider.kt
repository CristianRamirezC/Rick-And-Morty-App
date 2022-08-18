package com.example.rickandmortyapp.model.episodes

import com.example.rickandmortyapp.model.characters.Character

class EpisodeProvider {
    companion object {
        val episodesList = listOf<Episode>(
            Episode(
                episodeID = 1,
                episodeName = "Pilot",
                episodeAirDate = "December 2, 2013",
                episodeCode = "S01E01",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 2,
                episodeName = "Lawnmower Dog",
                episodeAirDate = "December 9, 2013",
                episodeCode = "S01E02",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 3,
                episodeName = "Anatomy Park",
                episodeAirDate = "December 16, 2013",
                episodeCode = "S01E03",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 4,
                episodeName = "M. Night Shaym-Aliens!",
                episodeAirDate = "January 13, 2014",
                episodeCode = "S01E04",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 5,
                episodeName = "Meeseeks and Destroy",
                episodeAirDate = "January 20, 2014",
                episodeCode = "S01E05",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 6,
                episodeName = "Rick Potion #9",
                episodeAirDate = "January 27, 2014",
                episodeCode = "S01E06",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 7,
                episodeName = "Raising Gazorpazorp",
                episodeAirDate = "March 10, 2014",
                episodeCode = "S01E07",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 8,
                episodeName = "Rixty Minutes",
                episodeAirDate = "March 10, 2014",
                episodeCode = "S01E08",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 9,
                episodeName = "Something Ricked This Way Comes",
                episodeAirDate = "March 10, 2014",
                episodeCode = "S01E09",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 10,
                episodeName = "Close Rick-counters of the Rick Kind",
                episodeAirDate = "March 10, 2014",
                episodeCode = "S01E10",
                episodeCharacters = listOf<Character>(),
            ),
            Episode(
                episodeID = 11,
                episodeName = "Close Rick-counters of the Rick Kind",
                episodeAirDate = "March 10, 2014",
                episodeCode = "S01E11",
                episodeCharacters = listOf<Character>(),
            )
        )
    }
}