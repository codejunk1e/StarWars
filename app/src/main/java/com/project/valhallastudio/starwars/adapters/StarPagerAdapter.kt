package com.project.valhallastudio.starwars.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.valhallastudio.starwars.R
import com.project.valhallastudio.starwars.models.Item
import com.project.valhallastudio.starwars.views.fragments.ResourceFragment

/**
 * @author Robin
 * Created on 5/6/20
 */
class StarPagerAdapter( fragment : Fragment) :  FragmentStateAdapter(fragment) {

    private val itemList = listOf(
        Item(R.drawable.one, "Luke Skywalker"),
        Item(R.drawable.two, "CP R7"),
        Item(R.drawable.dp, "Luke Skywalker"),
        Item(R.drawable.two, "CP R7"),
        Item(R.drawable.one, "Luke Skywalker"),
        Item(R.drawable.dp, "CP R7")
    )

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return ResourceFragment(itemList)
    }

   data class Resource(val name: String){}

}