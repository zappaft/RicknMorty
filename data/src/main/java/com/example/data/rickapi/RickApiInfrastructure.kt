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
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json


internal class RickApiInfrastructure: RickApiService {
    private companion object {
        const val baseUrl = "https://rickandmortyapi.com/api"
        const val characterUrl = "${baseUrl}/character"
        const val locationUrl = "${baseUrl}/location"
        const val episodeUrl = "${baseUrl}/episode"
    }

    override suspend fun getCharacters(url: String?): RickApiListResponse<Character> {
        return url?.let{
            makeRequest(url, Character.serializer())
        }?: makeRequest(characterUrl, Character.serializer())
    }

    override suspend fun getLocations(): List<Location> {
        val response: RickApiListResponse<Location> = makeRequest(locationUrl, Location.serializer())
        return response.results
    }

    override suspend fun getEpisodes(): List<Episode> {
        val response: RickApiListResponse<Episode> = makeRequest(episodeUrl, Episode.serializer())
        return response.results
    }

    private suspend inline fun <reified T> makeRequest(url: String, serializer: KSerializer<T>): RickApiListResponse<T> {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get(url)
        val parsedResponse: RickApiListResponse<T> = Json.decodeFromString(RickApiListResponse.serializer(serializer), response.readText())
        client.close()
        return parsedResponse
    }
}