package com.project.valhallastudio.starwars.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.valhallastudio.starwars.views.fragments.resources.PeopleFragment

/**
 * @author Robin
 * Created on 5/6/20
 */
class StarPagerAdapter( fragment : Fragment) :  FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return PeopleFragment()
    }

   data class Resource(val name: String){}

}