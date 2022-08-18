package com.example.rickandmortyapp.UI.characters.characterReview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
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
        setUpViews()

        return binding.root
    }

    private fun setUpViews() {
        val args = CharacterReviewFragmentArgs.fromBundle(requireArguments())
        binding.apply {
            tvCharacterName.text = args.characterName
            tvCharacterStatus.text = args.characterStatus
            tvCharacterSpecies.text = args.characterSpecies
            tvCharacterGender.text = args.characterGender
            tvCharacterOrigin.text = args.characterOrigin.locationName
            Glide.with(requireActivity())
                .load(args.characterImage)
                .into(binding.ivCharacterReviewImage)
        }
    }
}