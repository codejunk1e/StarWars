package com.project.valhallastudio.starwars.datasource

import androidx.paging.DataSource
import com.project.valhallastudio.starwars.models.responsemodels.Response
import kotlinx.coroutines.CoroutineScope

/**
 * @author kemosabe_x
 * Created on 6/5/20
 */
class ResourceDataFactory<V : Response> (private val scope: CoroutineScope, private val resource: String):
    DataSource.Factory<Int, V>() {


    override fun create(): DataSource<Int, V> {
        return ResourceDataSource<V>(scope, resource)
    }
}