package com.project.valhallastudio.starwars.webservice

import com.project.valhallastudio.starwars.models.responsemodels.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.lang.reflect.Type

/**
 * @author Robin
 * Created on 5/30/20
 */
interface StarWarsEndpoints {

    @GET("people/")
    suspend fun getPeopleResponse(
        @Query("page") page: Int
    ) : BaseResponse<PeopleResponse>

    @GET("planets/")
    suspend fun getPlanetsResponse(
        @Query("page") page: Int
    ) : BaseResponse<PlanetResponse>

    @GET("films/")
    suspend fun getFilmsResponse(
        @Query("page") page: Int
    ) : BaseResponse<FilmResponse>

    @GET("species/")
    suspend fun getSpeciesResponse(
        @Query("page") page: Int
    ) : BaseResponse<SpeciesResponse>

    @GET("vehicles/")
    suspend fun getVehiclesResponse(
        @Query("page") page: Int
    ) : BaseResponse<VehiclesResponse>

    @GET("starships/")
    suspend fun getStarshipsResponse(
        @Query("page") page: Int
    ) : BaseResponse<StarshipsResponse>


}