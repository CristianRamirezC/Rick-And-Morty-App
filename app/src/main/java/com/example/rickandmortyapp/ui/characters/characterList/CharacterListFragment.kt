package com.example.rickandmortyapp.ui.characters.characterList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.ui.characters.characterList.adapter.CharacterAdapter
import com.example.rickandmortyapp.ui.characters.characterList.adapter.util.SpacingItemDecoration
import com.example.rickandmortyapp.data.characters.*
import com.example.rickandmortyapp.databinding.FragmentCharacterListBinding
import com.example.rickandmortyapp.domain.characters.CharacterViewModel

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val viewModel: CharacterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCharacters()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            FragmentCharacterListBinding
                .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun initRecyclerView(characterList: List<Character>) {
        binding.rvCharactersRecyclerView.layoutManager =
            GridLayoutManager(requireActivity(), 2)

        binding.rvCharactersRecyclerView.adapter =
            CharacterAdapter(characterList) { character ->
                onItemSelected(character)
            }

        binding.rvCharactersRecyclerView
            .addItemDecoration(SpacingItemDecoration(20))
    }

    private fun renderCharactersRecyclerView(
        apiCallError: Boolean,
        characterAPIResponse: CharactersResponse
    ) {
        if (apiCallError) {
            showError()
        } else {
            binding.pbRecyclerProgressBar.isVisible = false
            initRecyclerView(characterAPIResponse.responseCharacters)
        }
    }

    private fun onItemSelected(character: Character) {
        findNavController().navigate(
            CharacterListFragmentDirections
                .actionCharactersFragmentToCharacterReviewFragment(
                    character.characterStatus,
                    character.characterSpecies,
                    character.characterGender,
                    character.characterOrigin,
                    character.characterName,
                    character.characterImage
                )
        )
    }

    private fun showError() {
        Toast.makeText(
            requireActivity(),
            "An error has occurred!",
            Toast.LENGTH_LONG
        )
            .show()
    }

    private fun setUpObservers() {
        viewModel.characterResults
            .observe(viewLifecycleOwner) { characterAPIResponse ->
                renderCharactersRecyclerView(
                    viewModel.apiCallResponseError.value ?: true,
                    characterAPIResponse
                )
            }

        viewModel.apiCallResponseError
            .observe(viewLifecycleOwner) { apiCallError ->
                renderCharactersRecyclerView(
                    apiCallError,
                    viewModel.characterResults.value ?: CharactersResponse()
                )
            }
    }
}