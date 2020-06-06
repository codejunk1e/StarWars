package com.project.valhallastudio.starwars.datasource

import androidx.paging.DataSource
import com.project.valhallastudio.starwars.models.responsemodels.Response
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

/**
 * @author robin
 * Created on 6/5/20
 */
class ResourceDataFactory<V : Response> (private val context: CoroutineContext, private val resource: String):
    DataSource.Factory<Int, V>() {


    override fun create(): DataSource<Int, V> {
        return ResourceDataSource<V>(context, resource)
    }
}