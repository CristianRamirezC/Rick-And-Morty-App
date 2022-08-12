package com.example.rickandmortyapp.UI.character.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.CharacterViewBinding
import com.example.rickandmortyapp.model.Character

class CharacterViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CharacterViewBinding.bind(view)
    fun render(character: Character) {
        binding.tvCharacterName.text = character.characterName
        Glide.with(view.context)
            .load(character.characterImage)
            .into(binding.ivCharacterImage)
    }
}