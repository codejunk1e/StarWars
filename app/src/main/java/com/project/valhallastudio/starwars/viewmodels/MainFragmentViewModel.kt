package com.project.valhallastudio.starwars.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.project.valhallastudio.starwars.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.datasource.ResourceDataFactory
import com.project.valhallastudio.starwars.models.responsemodels.*
import com.project.valhallastudio.starwars.repository.Repository
import kotlinx.coroutines.Dispatchers

/**
 * @author Robin
 * Created on 5/31/20
 */
class MainFragmentViewModel( ): ViewModel() {

    var peoplePagedList: LiveData<PagedList<PeopleResponse>>
    var filmPagedList: LiveData<PagedList<FilmResponse>>
    var planetPagedList: LiveData<PagedList<PlanetResponse>>
    var speciesPagedList: LiveData<PagedList<SpeciesResponse>>
    var starshipsPagedList: LiveData<PagedList<StarshipsResponse>>
    var vehiclesPagedList: LiveData<PagedList<VehiclesResponse>>

    init {
        val peopleData: ResourceDataFactory<PeopleResponse> =  ResourceDataFactory(Dispatchers.IO, "people")
        peoplePagedList = LivePagedListBuilder(
            peopleData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()

        val filmData: ResourceDataFactory<FilmResponse> =  ResourceDataFactory(Dispatchers.IO, "films")
        filmPagedList = LivePagedListBuilder(
            filmData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()

        val planetData: ResourceDataFactory<PlanetResponse> =  ResourceDataFactory(Dispatchers.IO, "films")
        planetPagedList = LivePagedListBuilder(
            planetData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()

        val speciesData: ResourceDataFactory<SpeciesResponse> =  ResourceDataFactory(Dispatchers.IO, "films")
        speciesPagedList = LivePagedListBuilder(
            speciesData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()

        val starshipsData: ResourceDataFactory<StarshipsResponse> =  ResourceDataFactory(Dispatchers.IO, "films")
        starshipsPagedList = LivePagedListBuilder(
            starshipsData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()
        val vehiclesData: ResourceDataFactory<VehiclesResponse> =  ResourceDataFactory(Dispatchers.IO, "films")
        vehiclesPagedList = LivePagedListBuilder(
            vehiclesData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()
    }

    private val repository = Repository()

    val resourceList = listOf(
        StarPagerAdapter.Resource("People"),
        StarPagerAdapter.Resource("Planets"),
        StarPagerAdapter.Resource("Films"),
        StarPagerAdapter.Resource("Species"),
        StarPagerAdapter.Resource("Vehicles"),
        StarPagerAdapter.Resource("Starships")
    )

}