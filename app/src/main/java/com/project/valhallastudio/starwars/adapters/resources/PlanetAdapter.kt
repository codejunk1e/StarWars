package com.project.valhallastudio.starwars.adapters.resources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.valhallastudio.starwars.R
import com.project.valhallastudio.starwars.models.responsemodels.FilmResponse
import com.project.valhallastudio.starwars.models.responsemodels.PlanetResponse
import com.project.valhallastudio.starwars.models.responsemodels.Response

/**
 * @author robin
 * Created on 6/3/20
 */
class PlanetAdapter:
    PagedListAdapter< PlanetResponse, PlanetAdapter.ViewHolder>(
        object: DiffUtil.ItemCallback<PlanetResponse> (){
            override fun areItemsTheSame(oldItem: PlanetResponse, newItem: PlanetResponse): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: PlanetResponse, newItem: PlanetResponse): Boolean {
                return oldItem.title == newItem.title
                }
        }
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val response: Response? = getItem(position);
        if (response != null){
            holder.bind(response, position)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            item: Response,
            position: Int
        ) {
            val itemImage = itemView.findViewById<ImageView>(R.id.itemImage)
            val itemText = itemView.findViewById<TextView>(R.id.itemTitle)
            itemText.text = item.name
            Glide.with(itemView.context).apply {
                when (position) {
                    1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18 -> load("https://starwars-visualguide.com/assets/img/planets/${position + 1}.jpg")
                    21-> load("https://starwars-visualguide.com/assets/img/planets/21.jpg")
                    else -> load((R.drawable.big_placeholder))
                }
                    .error(R.drawable.big_placeholder)
                    .override(350, 400)
                    .into(itemImage)
            }


        }
    }
}