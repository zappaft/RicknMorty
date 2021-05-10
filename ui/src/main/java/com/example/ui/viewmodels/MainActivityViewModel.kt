package com.example.ui.viewmodels

import cafe.adriel.dalek.Dalek
import cafe.adriel.dalek.DalekEvent
import com.example.domain.models.Character
import com.example.domain.models.Episode
import com.example.domain.models.ListInfo
import com.example.domain.models.Location
import com.example.domain.services.RickApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel(private val rickApiService: RickApiService) {
    var currentPageInfo: ListInfo? = null

    fun getCharacters(): Flow<DalekEvent<List<Character>>> {
        return Dalek(Dispatchers.IO) {
            currentPageInfo?.let { info ->
                info.next?.let { next ->
                    val result = rickApiService.getCharacters(next)
                    currentPageInfo = result.info
                    result.results
                }?: emptyList()
            }?:run{
                val result = rickApiService.getCharacters()
                currentPageInfo = result.info
                result.results
            }
        }
    }

    fun getLocations(): Flow<DalekEvent<List<Location>>> {
        return Dalek(Dispatchers.IO) {
            rickApiService.getLocations()
        }
    }

    fun getEpisodes(): Flow<DalekEvent<List<Episode>>> {
        return Dalek(Dispatchers.IO) {
            rickApiService.getEpisodes()
        }
    }
}