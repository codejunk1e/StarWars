package com.project.valhallastudio.starwars.adapters

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.valhallastudio.starwars.views.fragments.resources.*

/**
 * @author Robin
 * Created on 5/6/20
 */
class StarPagerAdapter( fragment : Fragment) :  FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = PeopleFragment()
            1 -> fragment = PlanetFragment()
            2 -> fragment =FilmFragment()
            3 -> fragment = SpeciesFragment()
            4 -> fragment = VehiclesFragments()
            5 -> fragment = StarshipsFragment()
        }
        return fragment!!
    }

   data class Resource(val name: String, @DrawableRes val icon: Int){}

}