package com.example.rickandmortyapp.ui.episodes.episodeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.data.episodes.Episode
import com.example.rickandmortyapp.data.episodes.EpisodesResponse
import com.example.rickandmortyapp.ui.episodes.episodeList.adapter.EpisodeAdapter
import com.example.rickandmortyapp.databinding.FragmentEpisodeListBinding
import com.example.rickandmortyapp.domain.episodes.EpisodeViewModel

class EpisodeListFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeListBinding
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
        binding = FragmentEpisodeListBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel
            .episodesResults
            .observe(viewLifecycleOwner) { episodeAPIResponse ->
                renderEpisodesRecyclerView(
                    viewModel.apiCallResponseError.value ?: true,
                    episodeAPIResponse
                )
            }

        viewModel
            .apiCallResponseError
            .observe(viewLifecycleOwner) { apiCallError ->
                renderEpisodesRecyclerView(
                    apiCallError,
                    viewModel.episodesResults.value
                        ?: EpisodesResponse()
                )

            }
    }

    private fun initRecyclerView(episodeList: List<Episode>) {
        binding.rvEpisodesRecyclerView.layoutManager =
            GridLayoutManager(requireActivity(), 1)

        binding.rvEpisodesRecyclerView.adapter =
            EpisodeAdapter(episodeList)
    }

    private fun renderEpisodesRecyclerView(
        apiCallError: Boolean,
        episodeAPIResponse: EpisodesResponse
    ) {
        if (apiCallError) {
            showError()
        } else {
            setLoadingVisibility(false)
            initRecyclerView(episodeAPIResponse.episodesList)
        }
    }

    private fun setLoadingVisibility(enabled: Boolean) {
        binding.pbRecyclerProgressBar.isVisible = enabled
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