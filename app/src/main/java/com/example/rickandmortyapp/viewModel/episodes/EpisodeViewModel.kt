package com.example.rickandmortyapp.viewModel.episodes

import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.model.episodes.APIEpisodesService
import com.example.rickandmortyapp.model.episodes.EpisodesInfo
import com.example.rickandmortyapp.model.episodes.EpisodesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodeViewModel : ViewModel() {
    private var _episodesResults = MutableLiveData<EpisodesResponse>()
    val episodesResults: LiveData<EpisodesResponse>
        get() = _episodesResults

    fun getEpisodes() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<EpisodesResponse> =
                getRetrofit().create(APIEpisodesService::class.java).getEpisodes()
            _episodesResults.postValue(
                if (call.isSuccessful) {
                    call.body() ?: EpisodesResponse()
                } else {
                    EpisodesResponse(
                        EpisodesInfo(totalEpisodes = -1)
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