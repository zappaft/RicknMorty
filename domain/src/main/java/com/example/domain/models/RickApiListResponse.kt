package com.example.domain.models

data class RickApiListResponse<T>(
    val info: ListInfo,
    val results: List<T>
)