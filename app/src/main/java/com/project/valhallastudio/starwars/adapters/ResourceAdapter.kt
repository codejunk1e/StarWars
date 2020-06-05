package com.project.valhallastudio.starwars.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.valhallastudio.starwars.R
import com.project.valhallastudio.starwars.models.Item
import com.project.valhallastudio.starwars.models.responsemodels.FilmResponse
import com.project.valhallastudio.starwars.models.responsemodels.Response

/**
 * @author robin
 * Created on 6/3/20
 */
class ResourceAdapter <T : Response>( private val images : List<Int> ) :
    PagedListAdapter<T, ResourceAdapter.ViewHolder>(
        object: DiffUtil.ItemCallback<T> (){
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                return if (oldItem !is  FilmResponse && newItem !is  FilmResponse){
                    oldItem.name == newItem.name
                } else{
                    oldItem.title == newItem.title
                }            }

        }
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val response = getItem(position);
        if (response != null){
            holder.bind(response, images[position])
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Response,  @DrawableRes image: Int) {
            val itemImage = itemView.findViewById<ImageView>(R.id.itemImage)
            val itemText = itemView.findViewById<TextView>(R.id.itemTitle)
            itemImage.setImageResource(image)

            when(item){
                !is  FilmResponse -> itemText.text = item.name
                else -> itemText.text = item.title
            }

        }
    }
}