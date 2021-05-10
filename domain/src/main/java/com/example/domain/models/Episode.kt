package com.example.domain.models

import kotlinx.serialization.Serializable as KotlinSerializable
import java.io.Serializable as JavaSerializable

@KotlinSerializable
data class Episode(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
): JavaSerializable