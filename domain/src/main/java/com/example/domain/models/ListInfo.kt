package com.example.domain.models

import kotlinx.serialization.Serializable as KotlinSerializable
import java.io.Serializable as JavaSerializable

@KotlinSerializable
data class ListInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
): JavaSerializable