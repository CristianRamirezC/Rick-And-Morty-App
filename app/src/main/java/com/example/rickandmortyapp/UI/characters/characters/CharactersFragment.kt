package com.example.rickandmortyapp.UI.characters.characters

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
import com.example.rickandmortyapp.UI.characters.characters.adapter.CharacterAdapter
import com.example.rickandmortyapp.UI.characters.characters.adapter.util.SpacingItemDecoration
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.characters.*
import com.example.rickandmortyapp.viewModel.characters.CharacterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private val viewModel: CharacterViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            FragmentCharactersBinding.inflate(inflater, container, false)
        viewModel.getCharacters()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.characterResults.observe(viewLifecycleOwner) {
            renderCharactersRecyclerView()
        }
    }

    private fun initRecyclerView() {
        binding.rvCharactersRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvCharactersRecyclerView.adapter =
            CharacterAdapter(viewModel.characterResults.value!!.responseCharacters) { character ->
                onItemSelected(character)
            }
        binding.rvCharactersRecyclerView.addItemDecoration(SpacingItemDecoration(20))
    }

    private fun renderCharactersRecyclerView() {
        if ((viewModel.characterResults.value!!.charactersInfo!!
                .totalCharacters == -1)
        ) {
            showError()
        } else {
            binding.pbRecyclerProgressBar.isVisible = false
            initRecyclerView()
        }
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

    private fun showError() {
        Toast.makeText(requireActivity(), "An error has occurred!", Toast.LENGTH_SHORT).show()
    }
}