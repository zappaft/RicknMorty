package com.example.domain.services

import com.example.domain.models.Character
import com.example.domain.models.Episode
import com.example.domain.models.Location
import com.example.domain.models.RickApiListResponse

interface RickApiService {
    suspend fun getCharacters(): RickApiListResponse<Character>

    suspend fun getLocations(): RickApiListResponse<Location>

    suspend fun getEpisodes(): RickApiListResponse<Episode>
}