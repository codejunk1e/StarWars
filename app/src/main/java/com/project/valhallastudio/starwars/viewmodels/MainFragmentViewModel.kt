package com.project.valhallastudio.starwars.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.project.valhallastudio.starwars.R
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
    private val repository = Repository()

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

        val planetData: ResourceDataFactory<PlanetResponse> =  ResourceDataFactory(Dispatchers.IO, "planets")
        planetPagedList = LivePagedListBuilder(
            planetData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()

        val speciesData: ResourceDataFactory<SpeciesResponse> =  ResourceDataFactory(Dispatchers.IO, "species")
        speciesPagedList = LivePagedListBuilder(
            speciesData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()

        val starshipsData: ResourceDataFactory<StarshipsResponse> =  ResourceDataFactory(Dispatchers.IO, "starships")
        starshipsPagedList = LivePagedListBuilder(
            starshipsData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()
        val vehiclesData: ResourceDataFactory<VehiclesResponse> =  ResourceDataFactory(Dispatchers.IO, "vehicles")
        vehiclesPagedList = LivePagedListBuilder(
            vehiclesData,
            PagedList.Config
                .Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        ).build()
    }



    val resourceList = listOf(
        StarPagerAdapter.Resource("Characters", R.drawable.ic_characters),
        StarPagerAdapter.Resource("Planets", R.drawable.ic_characters),
        StarPagerAdapter.Resource("Films", R.drawable.ic_characters),
        StarPagerAdapter.Resource("Species", R.drawable.ic_characters),
        StarPagerAdapter.Resource("Vehicles", R.drawable.ic_characters),
        StarPagerAdapter.Resource("Starships", R.drawable.ic_characters)
    )

}