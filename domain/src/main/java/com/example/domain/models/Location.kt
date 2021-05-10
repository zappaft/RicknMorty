package com.example.domain.models

import kotlinx.serialization.Serializable as KotlinSerializable
import java.io.Serializable as JavaSerializable

@KotlinSerializable
data class Location(
    val id: Int? = null,
    val name: String,
    val url: String,
    val dimension: String = "",
    val residents: List<String> = listOf(),
    val type: String = "",
    val created: String = ""
): JavaSerializable