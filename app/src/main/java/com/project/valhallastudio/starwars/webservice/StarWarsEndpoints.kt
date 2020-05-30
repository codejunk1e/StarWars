package com.project.valhallastudio.starwars.webservice

import com.project.valhallastudio.starwars.responsemodels.RootResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * @author kemosabe_x
 * Created on 5/30/20
 */
interface StarWarsEndpoints {

    @GET
    fun getRootResponse(@Url rootUrl : String) : Call<RootResponse>

}