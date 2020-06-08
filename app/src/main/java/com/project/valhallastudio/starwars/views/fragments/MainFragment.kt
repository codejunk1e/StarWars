package com.project.valhallastudio.starwars.views.fragments

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.palette.graphics.Palette
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.valhallastudio.starwars.R
import com.project.valhallastudio.starwars.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.databinding.FragmentMainBinding
import com.project.valhallastudio.starwars.viewmodels.MainFragmentViewModel
import com.project.valhallastudio.starwars.views.activities.MainActivity
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
            tab.icon = resources.getDrawable(viewModel.resourceList[position].icon)

        }.attach()

        binding.viewpagerMain.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    var headerImage : Int? = null

                    when(position){
                        0 -> headerImage = R.drawable.character
                        1 -> headerImage = R.drawable.planets
                        2 -> headerImage = R.drawable.films
                        3 -> headerImage = R.drawable.species
                        4 -> headerImage = R.drawable.vehicles
                        5 -> headerImage = R.drawable.starships
                    }

                    if (headerImage != null) {
                        imageview_main.setImageResource(headerImage)
                        val bitmap = BitmapFactory.decodeResource(resources, headerImage)
                        Palette.from(bitmap).generate {

                            @SuppressLint("ResourceAsColor")
                            val paletteColor: Int = it!!.getMutedColor(R.color.colorPrimaryDark)
                            (activity as MainActivity).updateStatusBarColor(paletteColor)
                            collapsingtoolbarlayout_main.setStatusBarScrimColor(paletteColor)
                            collapsingtoolbarlayout_main.setContentScrimColor(paletteColor)
                            tab_layout_main.setTabTextColors(paletteColor, paletteColor)
                            tab_layout_main.setSelectedTabIndicatorColor(paletteColor)
                        }
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
