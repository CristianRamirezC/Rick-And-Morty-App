package com.example.rickandmortyapp.domain.characters

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.RetrofitUtil
import com.example.rickandmortyapp.data.characters.APICharactersService
import com.example.rickandmortyapp.data.characters.CharactersResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class CharacterViewModel : ViewModel() {
    private val retrofit: RetrofitUtil = RetrofitUtil()

    private val _characterResults = MutableLiveData<CharactersResponse>()
    val characterResults: LiveData<CharactersResponse>
        get() = _characterResults

    private val _apiCallResponseError = MutableLiveData<Boolean>()
    val apiCallResponseError: LiveData<Boolean>
        get() = _apiCallResponseError

    fun getCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiCall: Response<CharactersResponse> =
                retrofit.getRetrofit().create(APICharactersService::class.java)
                    .getCharacters()
            if (apiCall.isSuccessful) {
                _apiCallResponseError.postValue(false)
                _characterResults.postValue(
                    apiCall.body() ?: CharactersResponse()
                )
            } else {
                _apiCallResponseError.postValue(true)
            }
        }
    }
}