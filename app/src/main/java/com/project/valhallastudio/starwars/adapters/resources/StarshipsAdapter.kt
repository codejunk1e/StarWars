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
import com.project.valhallastudio.starwars.models.responsemodels.StarshipsResponse

/**
 * @author robin
 * Created on 6/3/20
 */
class StarshipsAdapter:
    PagedListAdapter< StarshipsResponse, StarshipsAdapter.ViewHolder>(
        object: DiffUtil.ItemCallback<StarshipsResponse> (){
            override fun areItemsTheSame(oldItem: StarshipsResponse, newItem: StarshipsResponse): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: StarshipsResponse, newItem: StarshipsResponse): Boolean {
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
                when (position) {
                    2 -> load("https://starwars-visualguide.com/assets/img/starships/5.jpg")
                    3 -> load("https://starwars-visualguide.com/assets/img/starships/9.jpg")
                    4 -> load("https://starwars-visualguide.com/assets/img/starships/10.jpg")
                    5 -> load("https://starwars-visualguide.com/assets/img/starships/11.jpg")
                    6 -> load("https://starwars-visualguide.com/assets/img/starships/12.jpg")
                    7 -> load("https://starwars-visualguide.com/assets/img/starships/13.jpg")
                     8 -> load("https://starwars-visualguide.com/assets/img/starships/15.jpg")
                    10 -> load("https://starwars-visualguide.com/assets/img/starships/21.jpg")
                    11 -> load("https://starwars-visualguide.com/assets/img/starships/22.jpg")
                    12 -> load("https://starwars-visualguide.com/assets/img/starships/23.jpg")
                    13 -> load("https://starwars-visualguide.com/assets/img/starships/27.jpg")
                    14 -> load("https://starwars-visualguide.com/assets/img/starships/28.jpg")
                    15 -> load("https://starwars-visualguide.com/assets/img/starships/29.jpg")
                    16 -> load("https://starwars-visualguide.com/assets/img/starships/31.jpg")
                    18 -> load("https://starwars-visualguide.com/assets/img/starships/39.jpg")
                    19 -> load("https://starwars-visualguide.com/assets/img/starships/40.jpg")
                    20 -> load("https://starwars-visualguide.com/assets/img/starships/41.jpg")
                    21 -> load("https://starwars-visualguide.com/assets/img/starships/43.jpg")
                    22 -> load("https://starwars-visualguide.com/assets/img/starships/47.jpg")
                    23-> load("https://starwars-visualguide.com/assets/img/starships/48.jpg")
                    else -> load((R.drawable.big_placeholder))
                }
                    .override(350, 400)
                    .into(itemImage)
            }

        }
    }
}