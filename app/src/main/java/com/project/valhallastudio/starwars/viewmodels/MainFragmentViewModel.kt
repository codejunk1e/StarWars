package com.project.valhallastudio.starwars.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.project.valhallastudio.starwars.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.datasource.ResourceDataFactory
import com.project.valhallastudio.starwars.models.responsemodels.PeopleResponse
import com.project.valhallastudio.starwars.repository.Repository
import kotlinx.coroutines.Dispatchers

/**
 * @author Robin
 * Created on 5/31/20
 */
class MainFragmentViewModel( ): ViewModel() {

    var peoplePagedList: LiveData<PagedList<PeopleResponse>>

    init {
        val peopleData: ResourceDataFactory<PeopleResponse> =  ResourceDataFactory(Dispatchers.IO, "people")
        peoplePagedList = LivePagedListBuilder(
            peopleData,
            PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(10).build()
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