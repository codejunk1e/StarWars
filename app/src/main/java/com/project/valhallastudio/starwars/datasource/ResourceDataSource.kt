package com.project.valhallastudio.starwars.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.project.valhallastudio.starwars.models.responsemodels.Response
import com.project.valhallastudio.starwars.webservice.StarWarsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

/**
 * @author robin
 * Created on 6/5/20
 */
class ResourceDataSource< T : Response> (private val context: CoroutineContext, private val resource: String):
    PageKeyedDataSource<Int, T>() {

    private val FIRST_PAGE = 1
    private val job = Job()
    private val scope = CoroutineScope(coroutineContext + job)


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

                callback.onResult(response.body()?.results as MutableList<T>, null, FIRST_PAGE + 1)
            } catch (e :Exception){
                Log.e("OkHttp", "Failed to fetch data!")
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

                val key = if (response.body()?.next != null) params.key + 1 else null
                callback.onResult(response.body()?.results as MutableList<T>, key)
            } catch (e :Exception){
                Log.e("OkHttp", "Failed to fetch data!")
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


                if (response.isSuccessful) {

                }

                val key = if (response.body()?.previous != null) params.key - 1 else null
                callback.onResult(response.body()?.results as MutableList<T>, key)
            } catch (e :Exception){
                Log.e("OkHttp", "Failed to fetch data!")
            }

        }
    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }
}