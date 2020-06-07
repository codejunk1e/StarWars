package com.project.valhallastudio.starwars.webservice

import com.project.valhallastudio.starwars.models.responsemodels.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response
import java.lang.reflect.Type

/**
 * @author Robin
 * Created on 5/30/20
 */
interface StarWarsEndpoints {

    @GET("{resource}/")
    suspend fun getGenericResponse(
        @Path("resource") resource : String,
        @Query("page") page: Int
    ) : Response <BaseResponse<com.project.valhallastudio.starwars.models.responsemodels.Response>>


}