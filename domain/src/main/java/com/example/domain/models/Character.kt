package com.example.domain.models

import kotlinx.serialization.Serializable as KotlinSerializable
import java.io.Serializable as JavaSerializable

@KotlinSerializable
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
): JavaSerializable