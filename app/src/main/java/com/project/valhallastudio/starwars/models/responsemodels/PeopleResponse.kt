package com.project.valhallastudio.starwars.models.responsemodels

import com.google.gson.annotations.SerializedName

/**
 * @author robin
 * Created on 6/7/20
 */
data class PeopleResponse(
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("homeworld")
    val homeworld: String,
    @SerializedName("mass")
    val mass: String,
    @SerializedName("name")
    override var name: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("starships")
    val starships: List<String>,
    @SerializedName("url")
    override var url: String,
    @SerializedName("vehicles")
    val vehicles: List<String>
): Response()