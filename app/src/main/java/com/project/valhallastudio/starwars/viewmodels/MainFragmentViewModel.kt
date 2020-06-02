package com.project.valhallastudio.starwars.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.valhallastudio.starwars.repository.Repository
import com.project.valhallastudio.starwars.responsemodels.RootResponse
import kotlinx.coroutines.*

/**
 * @author Robin
 * Created on 5/31/20
 */
class MainFragmentViewModel( ): ViewModel() {

    private val repository = Repository()


    fun getList (): List<String> {
        return listOf<String>(
            "People",
            "Planets",
            "Films",
            "Species",
            "Vehicles",
            "Starships"
        )
    }

    private suspend fun getResponseAsync () : RootResponse {
        return repository.getRootResponseAsync()
    }

}