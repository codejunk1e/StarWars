package com.project.valhallastudio.starwars.views.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.valhallastudio.starwars.views.fragments.ResourceContentFragment

/**
 * @author Robin
 * Created on 5/6/20
 */
class StarPagerAdapter (fragment : FragmentActivity) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = ResourceContentFragment()
        return fragment
    }

}