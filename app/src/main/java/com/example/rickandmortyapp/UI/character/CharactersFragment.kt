package com.example.rickandmortyapp.UI.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.UI.character.adapter.CharacterAdapter
import com.example.rickandmortyapp.UI.character.util.SpacingItemDecoration
import com.example.rickandmortyapp.databinding.CharacterViewBinding
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
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
        binding = FragmentCharactersBinding.inflate(layoutInflater, container, false)
        initRecyclerView()
        return binding.root

    }

    private fun initRecyclerView() {
        binding.rvCharactersRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvCharactersRecyclerView.adapter =
            CharacterAdapter(CharacterProvider.characterList)

        binding.rvCharactersRecyclerView.addItemDecoration(SpacingItemDecoration(20))
    }
}