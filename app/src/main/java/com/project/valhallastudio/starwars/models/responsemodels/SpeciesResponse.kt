package com.project.valhallastudio.starwars.models.responsemodels
import com.google.gson.annotations.SerializedName

    data class SpeciesResponse(
        @SerializedName("average_height")
        val averageHeight: String,
        @SerializedName("average_lifespan")
        val averageLifespan: String,
        @SerializedName("classification")
        val classification: String,
        @SerializedName("created")
        val created: String,
        @SerializedName("designation")
        val designation: String,
        @SerializedName("edited")
        val edited: String,
        @SerializedName("eye_colors")
        val eyeColors: String,
        @SerializedName("films")
        val films: List<String>,
        @SerializedName("hair_colors")
        val hairColors: String,
        @SerializedName("homeworld")
        val homeworld: String,
        @SerializedName("language")
        val language: String,
        @SerializedName("name")
        override var name: String,
        @SerializedName("people")
        val people: List<String>,
        @SerializedName("skin_colors")
        val skinColors: String,
        @SerializedName("url")
        val url: String
    ): Response()