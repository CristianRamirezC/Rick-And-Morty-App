package com.example.rickandmortyapp.UI.episodes.episodes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.UI.episodes.episodes.adapter.EpisodeAdapter
import com.example.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.example.rickandmortyapp.model.characters.APICharactersService
import com.example.rickandmortyapp.model.characters.CharactersResponse
import com.example.rickandmortyapp.model.episodes.APIEpisodesService
import com.example.rickandmortyapp.model.episodes.EpisodesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodesFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding
    private var episodesResults: EpisodesResponse = EpisodesResponse()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        getEpisodes()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvEpisodesRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 1)
        binding.rvEpisodesRecyclerView.adapter = EpisodeAdapter(episodesResults.episodesList)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getEpisodes() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<EpisodesResponse> =
                getRetrofit().create(APIEpisodesService::class.java).getEpisodes()
            val episodesBody = call.body()
            activity?.runOnUiThread {
                if (call.isSuccessful) {
                    episodesResults = episodesBody ?: EpisodesResponse()
                    binding.pbRecyclerProgressBar.isVisible = false
                    initRecyclerView()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireActivity(), "An error has occurred!", Toast.LENGTH_SHORT).show()
    }
}