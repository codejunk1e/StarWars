package com.project.valhallastudio.starwars.models.responsemodels


import com.google.gson.annotations.SerializedName

data class RootResponse(
    @SerializedName("films")
    val films: String,
    @SerializedName("people")
    val people: String,
    @SerializedName("planets")
    val planets: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("starships")
    val starships: String,
    @SerializedName("vehicles")
    val vehicles: String
)