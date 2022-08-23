package com.example.rickandmortyapp.UI.episodes.episodes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.UI.episodes.episodes.adapter.EpisodeAdapter
import com.example.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.example.rickandmortyapp.model.characters.APICharactersService
import com.example.rickandmortyapp.model.characters.CharactersResponse
import com.example.rickandmortyapp.model.episodes.APIEpisodesService
import com.example.rickandmortyapp.model.episodes.EpisodesResponse
import com.example.rickandmortyapp.viewModel.episodes.EpisodeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodesFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding
    private val viewModel: EpisodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getEpisodes()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEpisodesBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
            .episodesResults
            .observe(viewLifecycleOwner) {
                renderEpisodesRecyclerView()
            }
    }

    private fun initRecyclerView() {
        binding.rvEpisodesRecyclerView.layoutManager =
            GridLayoutManager(requireActivity(), 1)

        binding.rvEpisodesRecyclerView.adapter =
            EpisodeAdapter(
                viewModel
                    .episodesResults
                    .value!!
                    .episodesList
            )
    }

    private fun renderEpisodesRecyclerView() {
        if (viewModel
                .episodesResults
                .value!!
                .episodesInfo!!
                .totalEpisodes == -1
        ) {
            showError()
        } else {
            binding.pbRecyclerProgressBar.isVisible = false
            initRecyclerView()
        }
    }


    private fun showError() {
        Toast.makeText(
            requireActivity(),
            "An error has occurred!",
            Toast.LENGTH_SHORT
        )
            .show()
    }
}