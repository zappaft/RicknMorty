package com.example.data.rickapi

import com.example.domain.models.Character
import com.example.domain.models.Episode
import com.example.domain.models.Location
import com.example.domain.models.RickApiListResponse
import com.example.domain.services.RickApiService
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class RickApiInfrastructure: RickApiService {
    private val baseUrl = "https://rickandmortyapi.com/api"
    private val 

    override suspend fun getCharacters(): RickApiListResponse<Character> {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("$baseUrl")
        println(response)
        client.close()
        TODO()
    }

    fun getCharacterById(id: Int) {
        TODO()
    }

    override suspend fun getLocations(): RickApiListResponse<Location> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodes(): RickApiListResponse<Episode> {
        TODO("Not yet implemented")
    }
}