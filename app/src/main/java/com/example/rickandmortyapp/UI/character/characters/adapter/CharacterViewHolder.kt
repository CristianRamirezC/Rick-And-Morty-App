package com.example.rickandmortyapp.UI.character.characters.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.databinding.CharacterViewBinding
import com.example.rickandmortyapp.model.Character

class CharacterViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CharacterViewBinding.bind(view)
    fun render(character: Character, onClickListener: (Character) -> Unit) {
        binding.tvCharacterName.text = character.characterName
        Glide.with(view.context)
            .load(character.characterImage)
            .into(binding.ivCharacterImage)
        itemView.setOnClickListener {
            onClickListener(character)
        }
    }
}