package com.project.valhallastudio.starwars.models.responsemodels

import com.google.gson.annotations.SerializedName

/**
 * @author robin
 * Created on 6/7/20
 */
data class PlanetResponse(
    @SerializedName("climate")
    val climate: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("diameter")
    val diameter: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("gravity")
    val gravity: String,
    @SerializedName("name")
    override var name: String,
    @SerializedName("orbital_period")
    val orbitalPeriod: String,
    @SerializedName("population")
    val population: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("rotation_period")
    val rotationPeriod: String,
    @SerializedName("surface_water")
    val surfaceWater: String,
    @SerializedName("terrain")
    val terrain: String,
    @SerializedName("url")
    override var url: String
): Response()
