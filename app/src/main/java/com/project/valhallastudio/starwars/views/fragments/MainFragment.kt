package com.project.valhallastudio.starwars.views.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.valhallastudio.starwars.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.databinding.FragmentMainBinding
import com.project.valhallastudio.starwars.responsemodels.RootResponse
import com.project.valhallastudio.starwars.viewmodels.MainActivityViewModel
import com.project.valhallastudio.starwars.viewmodels.MainFragmentViewModel
import com.project.valhallastudio.starwars.webservice.StarWarsService
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val list = listOf(
            StarPagerAdapter.ResourceFragment("People"),
            StarPagerAdapter.ResourceFragment("Planets"),
            StarPagerAdapter.ResourceFragment("Films"),
            StarPagerAdapter.ResourceFragment("Species"),
            StarPagerAdapter.ResourceFragment("Vehicles"),
            StarPagerAdapter.ResourceFragment("Starships")
        )


        val starPagerAdapter = StarPagerAdapter(list)
        binding.viewpagerMain.adapter = starPagerAdapter


        TabLayoutMediator(binding.tabLayoutMain, binding.viewpagerMain){ tab: TabLayout.Tab, position: Int ->
            tab.text = viewModel.getList()[position]
        }.attach()



    }
}
