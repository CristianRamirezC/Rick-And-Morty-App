package com.example.rickandmortyapp.domain.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.RetrofitUtil
import com.example.rickandmortyapp.data.characters.APICharactersService
import com.example.rickandmortyapp.data.characters.CharactersInfo
import com.example.rickandmortyapp.data.characters.CharactersResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterViewModel : ViewModel() {
    private val _characterResults = MutableLiveData<CharactersResponse>()
    private val retrofit: RetrofitUtil = RetrofitUtil()

    val characterResults: LiveData<CharactersResponse>
        get() = _characterResults

    fun getCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<CharactersResponse> =
                retrofit.getRetrofit().create(APICharactersService::class.java)
                    .getCharacters()

            _characterResults.postValue(
                //invertir condicion
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
}