package com.example.rickandmortyapp.UI.character.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.UI.character.characters.adapter.CharacterAdapter
import com.example.rickandmortyapp.UI.character.characters.util.SpacingItemDecoration
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.model.CharacterProvider

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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