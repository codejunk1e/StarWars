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
import com.project.valhallastudio.starwars.models.responsemodels.Response
import com.project.valhallastudio.starwars.models.responsemodels.VehiclesResponse

/**
 * @author robin
 * Created on 6/3/20
 */
class VehiclesAdapter:
    PagedListAdapter< VehiclesResponse, VehiclesAdapter.ViewHolder>(
        object: DiffUtil.ItemCallback<VehiclesResponse> (){
            override fun areItemsTheSame(oldItem: VehiclesResponse, newItem: VehiclesResponse): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: VehiclesResponse, newItem: VehiclesResponse): Boolean {
                return oldItem.name == newItem.name

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
            itemImage.setImageResource(R.drawable.dp)
            itemText.text = item.name
            Glide.with(itemView.context).apply {
                when(position){
                    0 -> load("https://starwars-visualguide.com/assets/img/vehicles/4.jpg")
                    1 -> load("https://starwars-visualguide.com/assets/img/vehicles/6.jpg")
                    2 -> load("https://starwars-visualguide.com/assets/img/vehicles/7.jpg")
                    3 -> load("https://starwars-visualguide.com/assets/img/vehicles/8.jpg")
                    4 -> load("https://starwars-visualguide.com/assets/img/vehicles/14.jpg")
                    5 -> load("https://starwars-visualguide.com/assets/img/vehicles/16.jpg")
                    6 -> load("https://starwars-visualguide.com/assets/img/vehicles/18.jpg")
                    7 -> load("https://starwars-visualguide.com/assets/img/vehicles/19.jpg")
                    8 -> load("https://starwars-visualguide.com/assets/img/vehicles/20.jpg")
                    9 -> load("https://starwars-visualguide.com/assets/img/vehicles/24.jpg")
                    10 -> load("https://starwars-visualguide.com/assets/img/vehicles/25.jpg")
                    11 -> load("https://starwars-visualguide.com/assets/img/vehicles/26.jpg")
                    12 -> load("https://starwars-visualguide.com/assets/img/vehicles/30.jpg")
                    13 -> load("https://starwars-visualguide.com/assets/img/vehicles/33.jpg")
                    14 -> load("https://starwars-visualguide.com/assets/img/vehicles/34.jpg")
                    15 -> load("https://starwars-visualguide.com/assets/img/vehicles/35.jpg")
                    16 -> load("https://starwars-visualguide.com/assets/img/vehicles/36.jpg")
                    17 -> load("https://starwars-visualguide.com/assets/img/vehicles/37.jpg")
                    18 -> load("https://starwars-visualguide.com/assets/img/vehicles/38.jpg")
                    19 -> load("https://starwars-visualguide.com/assets/img/vehicles/42.jpg")
                    else -> load((R.drawable.big_placeholder))
                }
                    .error(R.drawable.big_placeholder)
                    .override(350, 400)
                    .into(itemImage)
            }


        }
    }
}