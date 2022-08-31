package com.example.rickandmortyapp.domain.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.RetrofitUtil
import com.example.rickandmortyapp.data.episodes.APIEpisodesService
import com.example.rickandmortyapp.data.episodes.EpisodesInfo
import com.example.rickandmortyapp.data.episodes.EpisodesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodeViewModel : ViewModel() {
    private var _episodesResults = MutableLiveData<EpisodesResponse>()
    private val retrofit: RetrofitUtil = RetrofitUtil()

    private val _apiCallResponseError = MutableLiveData<Boolean>()
    val apiCallResponseError: LiveData<Boolean>
        get() = _apiCallResponseError


    val episodesResults: LiveData<EpisodesResponse>
        get() = _episodesResults

    fun getEpisodes() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiCall: Response<EpisodesResponse> =
                retrofit.getRetrofit().create(APIEpisodesService::class.java).getEpisodes()
            if (apiCall.isSuccessful) {
                _apiCallResponseError.postValue(false)
                _episodesResults.postValue(
                    apiCall.body() ?: EpisodesResponse()
                )
            } else {
                _apiCallResponseError.postValue(true)
            }
        }
    }
}