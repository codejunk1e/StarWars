package com.project.valhallastudio.starwars.repository

import com.project.valhallastudio.starwars.responsemodels.RootResponse
import com.project.valhallastudio.starwars.webservice.StarWarsService
import kotlinx.coroutines.Deferred

/**
 * @author robin
 * Created on 5/30/20
 */
class Repository {

    companion object{
    }

    suspend fun getRootResponseAsync() : RootResponse {
        return StarWarsService.getInstance().getRootResponseAsync()
    }


}