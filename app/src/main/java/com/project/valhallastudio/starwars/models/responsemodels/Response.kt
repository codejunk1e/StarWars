package com.project.valhallastudio.starwars.models.responsemodels

/**
 * @author robin
 * Created on 6/3/20
 * Generic Response abstract class for all the Response Models to implement.
 * This is so I don't have to create special PagedListAdapter for each!!
 */
abstract class Response(open var name: String = "", open var title: String = "", open var url: String = "") {

}