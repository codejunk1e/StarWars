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

/**
 * @author robin
 * Created on 6/3/20
 */
class FilmAdapter:
    PagedListAdapter< FilmResponse, FilmAdapter.ViewHolder>(
        object: DiffUtil.ItemCallback<FilmResponse> (){
            override fun areItemsTheSame(oldItem: FilmResponse, newItem: FilmResponse): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: FilmResponse, newItem: FilmResponse): Boolean {
                return oldItem.title == newItem.title
            }
        }
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
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
            var image_url = "https://starwars-visualguide.com/assets/img/films/${position + 1}.jpg"
            itemImage.setImageResource(R.drawable.dp)
            itemText.text = item.title
            Glide.with(itemView.context)
                .load("https://starwars-visualguide.com/assets/img/films/${position + 1}.jpg")
                .override(350, 400)
                .into(itemImage)
        }

    }

}