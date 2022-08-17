package com.example.rickandmortyapp.model.characters

import com.example.rickandmortyapp.model.characters.Character

class CharacterProvider {
    companion object {
        val characterList = listOf<Character>(
            Character(
                characterID = 1,
                characterName = "Rick Sanchez",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (C-137)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            ),
            Character(
                characterID = 2,
                characterName = "Morty Smith",
                characterStatus = "Dead",
                characterGender = "Male",
                characterOrigin = "unknown",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            ),
            Character(
                characterID = 3,
                characterName = "Summer Smith",
                characterStatus = "Unknown",
                characterGender = "Female",
                characterOrigin = "Earth (Replacement Dimension)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/3.jpeg"
            ),
            Character(
                characterID = 4,
                characterName = "Beth Smith",
                characterStatus = "Alive",
                characterGender = "Female",
                characterOrigin = "Earth (Replacement Dimension)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/4.jpeg"
            ),
            Character(
                characterID = 5,
                characterName = "Jerry Smith",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (Replacement Dimension)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/5.jpeg"
            ),
            Character(
                characterID = 6,
                characterName = "Abadango Cluster Princess",
                characterStatus = "Alive",
                characterGender = "Female",
                characterOrigin = "Abadango",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/6.jpeg"
            ),
            Character(
                characterID = 7,
                characterName = "Gotron",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (C-137)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/7.jpeg"
            ),
            Character(
                characterID = 8,
                characterName = "Gotron",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (C-137)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/8.jpeg"
            ),
            Character(
                characterID = 9,
                characterName = "Gotron",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (C-137)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/9.jpeg"
            ),
            Character(
                characterID = 10,
                characterName = "Gotron",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (C-137)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/10.jpeg"
            ),
            Character(
                characterID = 11,
                characterName = "Gotron",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (C-137)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/11.jpeg"
            ),
            Character(
                characterID = 12,
                characterName = "Gotron",
                characterStatus = "Alive",
                characterGender = "Male",
                characterOrigin = "Earth (C-137)",
                characterSpecies = "Human",
                characterImage = "https://rickandmortyapi.com/api/character/avatar/12.jpeg"
            )
        )
    }
}