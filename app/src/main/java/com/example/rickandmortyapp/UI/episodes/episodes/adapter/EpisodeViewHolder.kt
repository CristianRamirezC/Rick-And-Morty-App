package com.example.rickandmortyapp.UI.episodes.episodes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.databinding.EpisodeItemViewBinding
import com.example.rickandmortyapp.data.episodes.Episode

class EpisodeViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
    private val binding = EpisodeItemViewBinding.bind(view)
    fun render(episode: Episode) {
        binding.tvEpisodeName.text = episode.episodeName
        binding.tvEpisodeCode.text = episode.episodeCode
        binding.tvEpisodeAirTime.text = episode.episodeAirDate
    }
}