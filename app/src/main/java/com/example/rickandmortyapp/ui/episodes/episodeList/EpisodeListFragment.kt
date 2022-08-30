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