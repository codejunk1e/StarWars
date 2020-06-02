package com.project.valhallastudio.starwars.webservice

import com.project.valhallastudio.starwars.responsemodels.RootResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * @author Robin
 * Created on 5/30/20
 */
interface StarWarsEndpoints {

    @GET("#")
     suspend fun getRootResponseAsync() : RootResponse


}