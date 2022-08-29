package com.example.rickandmortyapp.UI.characters.characterList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.characters.Character

class CharacterAdapter(
    private val characterList: List<Character>,
    private val onClickListener: (Character) -> Unit
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