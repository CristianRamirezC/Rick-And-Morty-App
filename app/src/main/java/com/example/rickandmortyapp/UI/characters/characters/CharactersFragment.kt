package com.example.rickandmortyapp.UI.characters.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.UI.characters.characters.adapter.CharacterAdapter
import com.example.rickandmortyapp.UI.characters.characters.adapter.util.SpacingItemDecoration
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.characters.Character
import com.example.rickandmortyapp.model.characters.CharacterProvider

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentCharactersBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvCharactersRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvCharactersRecyclerView.adapter =
            CharacterAdapter(CharacterProvider.characterList) { character ->
                onItemSelected(character)
            }
        binding.rvCharactersRecyclerView.addItemDecoration(SpacingItemDecoration(20))
    }

    private fun onItemSelected(character: Character) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterReviewFragment(
                character.characterStatus,
                character.characterSpecies,
                character.characterGender,
                character.characterOrigin,
                character.characterName,
                character.characterImage
            )
        )
    }
}