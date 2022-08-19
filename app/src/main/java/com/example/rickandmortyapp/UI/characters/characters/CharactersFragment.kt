package com.example.rickandmortyapp.UI.characters.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.UI.characters.characters.adapter.CharacterAdapter
import com.example.rickandmortyapp.UI.characters.characters.adapter.util.SpacingItemDecoration
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.characters.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private var characterResults: CharactersResponse = CharactersResponse(
        null, listOf()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentCharactersBinding.inflate(inflater, container, false)
        getCharacters()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvCharactersRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvCharactersRecyclerView.adapter =
            CharacterAdapter(characterResults.responseCharacters) { character ->
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

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<CharactersResponse> =
                getRetrofit().create(APICharactersService::class.java).getCharacters()
            val charactersBody = call.body()
            activity?.runOnUiThread {
                if (call.isSuccessful) {
                    characterResults = charactersBody ?: CharactersResponse(null, ArrayList())
                    binding.pbRecyclerProgressBar.isVisible = false
                    initRecyclerView()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireActivity(), "An error has occurred!", Toast.LENGTH_SHORT).show()
    }
}