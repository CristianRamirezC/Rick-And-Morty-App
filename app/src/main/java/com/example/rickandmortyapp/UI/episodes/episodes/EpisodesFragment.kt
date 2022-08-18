package com.example.rickandmortyapp.UI.episodes.episodes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.UI.episodes.episodes.adapter.EpisodeAdapter
import com.example.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.example.rickandmortyapp.model.episodes.EpisodeProvider

class EpisodesFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvEpisodesRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 1)
        binding.rvEpisodesRecyclerView.adapter = EpisodeAdapter(EpisodeProvider.episodesList)
    }
}