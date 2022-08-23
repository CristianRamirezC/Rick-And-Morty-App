package com.example.rickandmortyapp.viewModel.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.model.characters.APICharactersService
import com.example.rickandmortyapp.model.characters.CharactersInfo
import com.example.rickandmortyapp.model.characters.CharactersResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterViewModel : ViewModel() {
    private val _characterResults = MutableLiveData<CharactersResponse>()

    val characterResults: LiveData<CharactersResponse>
        get() = _characterResults

    fun getCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<CharactersResponse> =
                getRetrofit().create(APICharactersService::class.java).getCharacters()
            _characterResults.postValue(
                if (call.isSuccessful) {
                    call.body() ?: CharactersResponse(CharactersInfo())
                } else {
                    CharactersResponse(
                        CharactersInfo(
                            totalCharacters = -1
                        ),
                    )
                }
            )
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}