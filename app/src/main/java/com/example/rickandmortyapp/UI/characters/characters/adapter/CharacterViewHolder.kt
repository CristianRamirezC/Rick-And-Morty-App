package com.example.rickandmortyapp.UI.characters.characters.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.CharacterItemViewBinding
import com.example.rickandmortyapp.model.characters.Character
import com.example.rickandmortyapp.model.characters.Results

class CharacterViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CharacterItemViewBinding.bind(view)
    fun render(character: Results, onClickListener: (Results) -> Unit) {
        binding.tvCharacterName.text = character.characterName
        Glide.with(view.context)
            .load(character.characterImage)
            .into(binding.ivCharacterImage)
        itemView.setOnClickListener {
            onClickListener(character)
        }
        renderCharacterStatus(character.characterStatus)

    }

    private fun renderCharacterStatus(status: String) {
        when (status) {
            "Dead" -> binding.ivCharacterStatus.background.setTint(
                ContextCompat.getColor(
                    view.context,
                    R.color.character_status_dead
                )
            )
            "Alive" -> binding.ivCharacterStatus.background.setTint(
                ContextCompat.getColor(
                    view.context,
                    R.color.character_status_alive
                )
            )
            "Unknown" -> binding.ivCharacterStatus.background.setTint(
                ContextCompat.getColor(
                    view.context,
                    R.color.character_Status_unknown
                )
            )
        }
    }
}