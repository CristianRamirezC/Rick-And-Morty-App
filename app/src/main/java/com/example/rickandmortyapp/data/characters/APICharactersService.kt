package com.example.rickandmortyapp.data.characters

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

private const val GET_CHARACTER_ENDPOINT_URL: String = "character?page=1"

interface APICharactersService {
    @GET
    suspend fun getCharacters(
        @Url url: String = GET_CHARACTER_ENDPOINT_URL
    ): Response<CharactersResponse>
}