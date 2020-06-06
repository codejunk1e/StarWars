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

















































    @GET("{resource}/")
    suspend fun getGenericPeopleResponse(
        @Path("resource") resource : String,
        @Query("page") page: Int
    ) : BaseResponse<PeopleResponse>

    @GET("{resource}/")
    suspend fun getGenericPlanetResponse(
        @Path("resource") resource : String,
        @Query("page") page: Int
    ) : BaseResponse<PlanetResponse>

    @GET("{resource}/")
    suspend fun getGenericFilmResponse(
        @Path("resource") resource : String,
        @Query("page") page: Int
    ) : BaseResponse<FilmResponse>

    @GET("{resource}/")
    suspend fun getGenericSpeciesResponse(
        @Path("resource") resource : String,
        @Query("page") page: Int
    ) : BaseResponse<SpeciesResponse>

    @GET("{resource}/")
    suspend fun getGenericVehicleResponse(
        @Path("resource") resource : String,
        @Query("page") page: Int
    ) : BaseResponse<VehiclesResponse>

    @GET("{resource}/")
    suspend fun getGenericStarshipResponse(
        @Path("resource") resource : String,
        @Query("page") page: Int
    ) : BaseResponse<StarshipsResponse>


}