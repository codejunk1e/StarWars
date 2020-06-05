package com.project.valhallastudio.starwars.datasource

import androidx.paging.PageKeyedDataSource
import com.project.valhallastudio.starwars.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.models.responsemodels.BaseResponse
import com.project.valhallastudio.starwars.models.responsemodels.PeopleResponse
import com.project.valhallastudio.starwars.models.responsemodels.Response
import com.project.valhallastudio.starwars.webservice.StarWarsEndpoints
import com.project.valhallastudio.starwars.webservice.StarWarsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * @author robin
 * Created on 6/5/20
 */
class ResourceDataSource< T : Response> (private val scope: CoroutineScope, private val resource: String):
    PageKeyedDataSource<Int, T>() {

    private val FIRST_PAGE = 1


    override fun  loadInitial (
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, T>
    ) {
        scope.launch {

            try{
                val response =
                    StarWarsService
                        .getInstance()
                        .getGenericResponse(resource, FIRST_PAGE)

                callback.onResult(response.results as MutableList<T>, null, FIRST_PAGE + 1)
            } catch (e :Exception){

            }

        }

    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, T>
    ) {

        scope.launch {
            try{
                val response =
                    StarWarsService
                        .getInstance()
                        .getGenericResponse(resource, params.key)

                val key = if (response.next != null) params.key + 1 else null
                callback.onResult(response.results as MutableList<T>, key)
            } catch (e :Exception){

            }
        }

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, T>
    ) {
        scope.launch {

            try{
                val response =
                    StarWarsService
                        .getInstance()
                        .getGenericResponse(resource, params.key)

                val key = if (response.previous != null) params.key - 1 else null
                callback.onResult(response.results as MutableList<T>, key)
            } catch (e :Exception){

            }

        }
    }
}