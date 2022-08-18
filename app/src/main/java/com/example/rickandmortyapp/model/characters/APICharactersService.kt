package com.example.rickandmortyapp.model.characters

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APICharactersService {
    @GET
    suspend fun getCharacters(@Url url: String = "character?page=1"): Response<CharactersResponse>
}