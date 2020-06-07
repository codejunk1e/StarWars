package com.project.valhallastudio.starwars.models.responsemodels

import com.google.gson.annotations.SerializedName

/**
 * @author robin
 * Created on 6/3/20
 * Generic Sealed class for all the Response Models to inherit from.
 * This is so I don't have to create special PagedListAdapter for each!!
 */
open class Response(open var name: String = "", open var title: String = "", open var url: String = "") {
}