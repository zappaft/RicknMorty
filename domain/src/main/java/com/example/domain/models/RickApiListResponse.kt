package com.example.domain.models

import kotlinx.serialization.Serializable as KotlinSerializable
import java.io.Serializable as JavaSerializable

@KotlinSerializable
data class  RickApiListResponse<T>(
    val info: ListInfo,
    val results: List<T>
): JavaSerializable