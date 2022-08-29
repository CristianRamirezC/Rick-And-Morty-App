package com.example.rickandmortyapp.data.episodes

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

private const val GET_EPISODE_ENDPOINT_URL: String = "episode#"

interface APIEpisodesService {
    @GET
    suspend fun getEpisodes(
        @Url url: String = GET_EPISODE_ENDPOINT_URL
    ): Response<EpisodesResponse>
}