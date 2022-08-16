package com.example.rickandmortyapp.UI.character.characterReview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentCharacterReviewBinding

class CharacterReviewFragment : Fragment() {

    private lateinit var binding: FragmentCharacterReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentCharacterReviewBinding.inflate(inflater, container, false)

        binding.characterReviewImageHeight =
            resources.getDimension(R.dimen.characters_review_image_height)
        return binding.root
    }
}