package com.project.valhallastudio.starwars.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.valhallastudio.starwars.R
import com.project.valhallastudio.starwars.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.databinding.FragmentMainBinding
import com.project.valhallastudio.starwars.viewmodels.MainFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @author Robin
 * Created on 5/6/20
 * A simple [Fragment] to show the Main Screen.
 */
class MainFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this)[MainFragmentViewModel::class.java]

    }
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val starPagerAdapter = StarPagerAdapter(this)
        binding.viewpagerMain.adapter = starPagerAdapter


        TabLayoutMediator(binding.tabLayoutMain, binding.viewpagerMain){ tab: TabLayout.Tab, position: Int ->
            tab.text = viewModel.resourceList[position].name
        }.attach()

        binding.viewpagerMain.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {

                    when(position){
                        0 -> imageview_main.setImageResource(R.drawable.character)
                        1 -> imageview_main.setImageResource(R.drawable.planets)
                        2 -> imageview_main.setImageResource(R.drawable.films)
                        3 -> imageview_main.setImageResource(R.drawable.species)
                        4 -> imageview_main.setImageResource(R.drawable.vehicles)
                        5 -> imageview_main.setImageResource(R.drawable.starships)

                    }
                }
            }
        )


    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
