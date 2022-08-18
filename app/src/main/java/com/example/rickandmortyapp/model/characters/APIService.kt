package com.example.rickandmortyapp.model.characters

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getCharacters(@Url url: String = "character"): Response<CharactersResponse>
}