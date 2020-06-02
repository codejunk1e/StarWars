package com.project.valhallastudio.starwars.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.valhallastudio.starwars.R

/**
 * @author Robin
 * Created on 5/6/20
 */
class StarPagerAdapter(private val data : List<ResourceFragment>) : RecyclerView.Adapter<StarPagerAdapter.ViewHolder>() {


    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.resource_sceen_items, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ResourceFragment) {
        }

    }
    data class ResourceFragment( val name: String){}
}