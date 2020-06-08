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
import com.project.valhallastudio.starwars.models.responsemodels.PeopleResponse
import com.project.valhallastudio.starwars.models.responsemodels.Response

/**
 * @author robin
 * Created on 6/3/20
 */
class PeopleAdapter:
    PagedListAdapter< PeopleResponse, PeopleAdapter.ViewHolder>(
        object: DiffUtil.ItemCallback<PeopleResponse> (){
            override fun areItemsTheSame(oldItem: PeopleResponse , newItem: PeopleResponse): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: PeopleResponse, newItem: PeopleResponse): Boolean {
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
            if (position > 15) {
                Glide.with(itemView.context)
                    .load("https://starwars-visualguide.com/assets/img/characters/${position + 2}.jpg")
                    .override(350, 400)
                    .error(R.drawable.big_placeholder)
                    .into(itemImage)
            }
            else{
                Glide.with(itemView.context)
                    .load("https://starwars-visualguide.com/assets/img/characters/${position + 1}.jpg")
                    .override(350, 400)
                    .error(R.drawable.big_placeholder)
                    .into(itemImage)
            }

        }
    }
}