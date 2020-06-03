package com.project.valhallastudio.starwars.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.project.valhallastudio.starwars.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.repository.Repository
import com.project.valhallastudio.starwars.models.responsemodels.RootResponse
import kotlinx.coroutines.Dispatchers

/**
 * @author Robin
 * Created on 5/31/20
 */
class MainFragmentViewModel( ): ViewModel() {

    private val repository = Repository()

//    fun getUsers() = liveData(Dispatchers.IO) {
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = mainRepository.getUsers()))
//        } catch (exception: Exception) {
//            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
//        }
//    }


    val resourceList = listOf(
        StarPagerAdapter.Resource("People"),
        StarPagerAdapter.Resource("Planets"),
        StarPagerAdapter.Resource("Films"),
        StarPagerAdapter.Resource("Species"),
        StarPagerAdapter.Resource("Vehicles"),
        StarPagerAdapter.Resource("Starships")
    )


}