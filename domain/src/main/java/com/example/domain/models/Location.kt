package com.example.domain.models

data class Location(
    val id: Int,
    val name: String,
    val url: String,
    val dimension: String = "",
    val residents: List<String> = listOf(),
    val type: String = "",
    val created: String = ""
)