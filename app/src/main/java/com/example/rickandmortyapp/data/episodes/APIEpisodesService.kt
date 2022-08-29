package com.example.rickandmortyapp.data.episodes

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIEpisodesService {
    @GET
    suspend fun getEpisodes(
        @Url url: String = "episode#"
    ): Response<EpisodesResponse>
}