package com.project.valhallastudio.starwars.models.responsemodels

import com.google.gson.annotations.SerializedName

    data class VehiclesResponse(
        @SerializedName("cargo_capacity")
        val cargoCapacity: String,
        @SerializedName("consumables")
        val consumables: String,
        @SerializedName("cost_in_credits")
        val costInCredits: String,
        @SerializedName("created")
        val created: String,
        @SerializedName("crew")
        val crew: String,
        @SerializedName("edited")
        val edited: String,
        @SerializedName("films")
        val films: List<String>,
        @SerializedName("length")
        val length: String,
        @SerializedName("manufacturer")
        val manufacturer: String,
        @SerializedName("max_atmosphering_speed")
        val maxAtmospheringSpeed: String,
        @SerializedName("model")
        val model: String,
        @SerializedName("name")
        override var name: String,
        @SerializedName("passengers")
        val passengers: String,
        @SerializedName("pilots")
        val pilots: List<String>,
        @SerializedName("url")
        override var url: String,
        @SerializedName("vehicle_class")
        val vehicleClass: String
    ): Response()