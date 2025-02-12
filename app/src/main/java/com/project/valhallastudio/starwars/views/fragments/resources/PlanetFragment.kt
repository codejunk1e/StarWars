package com.project.valhallastudio.starwars.views.fragments.resources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.project.valhallastudio.starwars.adapters.resources.PlanetAdapter
import com.project.valhallastudio.starwars.databinding.ResourceSceenItemsBinding
import com.project.valhallastudio.starwars.viewmodels.MainFragmentViewModel
import kotlinx.android.synthetic.main.resource_sceen_items.*

/**
 * @author robin
 * Created on 6/3/20
 */

class PlanetFragment() : Fragment() {
    private val resourceAdapter = PlanetAdapter()

    private val viewModel by lazy {
        ViewModelProviders.of(this)[MainFragmentViewModel::class.java]

    }

    private var _binding: ResourceSceenItemsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ResourceSceenItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resourceRecycler.adapter = resourceAdapter
        parentFragment?.viewLifecycleOwner?.let {
            viewModel.planetPagedList.observe(it, Observer {
                resourceAdapter.submitList(it)
            })
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}