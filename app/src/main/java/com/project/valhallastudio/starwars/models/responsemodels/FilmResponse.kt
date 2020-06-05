package com.project.valhallastudio.starwars.models.responsemodels


import com.google.gson.annotations.SerializedName

data class FilmResponse (
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("created")
    val created: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("episode_id")
    val episodeId: Int,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    @SerializedName("planets")
    val planets: List<String>,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("starships")
    val starships: List<String>,
    @SerializedName("title")
    override var title: String,
    @SerializedName("url")
    override var url: String,
    @SerializedName("vehicles")
    val vehicles: List<String>
) : Response()