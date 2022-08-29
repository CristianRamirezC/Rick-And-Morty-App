package com.example.rickandmortyapp.UI.episodes.episodeList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.episodes.Episode

class EpisodeAdapter(
    private val episodeList: List<Episode>
) : RecyclerView.Adapter<EpisodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EpisodeViewHolder(
            layoutInflater.inflate(R.layout.episode_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val item = episodeList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }
}