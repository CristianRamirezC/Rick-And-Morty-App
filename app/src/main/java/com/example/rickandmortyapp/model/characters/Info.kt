package com.example.rickandmortyapp.model.characters

data class Info(
    @Se var count: Int,
    var pages: Int,
    var next: String?,
    var prev: String?
)
