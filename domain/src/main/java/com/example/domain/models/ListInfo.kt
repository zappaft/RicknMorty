package com.example.domain.models

data class ListInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)