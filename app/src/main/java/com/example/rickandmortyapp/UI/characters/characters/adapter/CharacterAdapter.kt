package com.example.rickandmortyapp.UI.characters.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.characters.Character
import com.example.rickandmortyapp.model.characters.Results

class CharacterAdapter(
    private val characterList: List<Results>,
    private val onClickListener: (Results) -> Unit
) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(
            layoutInflater.inflate(R.layout.character_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = characterList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}