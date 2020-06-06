package com.project.valhallastudio.starwars.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.project.valhallastudio.starwars.adapters.ResourceAdapter
import com.project.valhallastudio.starwars.databinding.ResourceSceenItemsBinding
import com.project.valhallastudio.starwars.models.Item
import com.project.valhallastudio.starwars.models.responsemodels.PeopleResponse
import com.project.valhallastudio.starwars.viewmodels.MainFragmentViewModel
import kotlinx.android.synthetic.main.resource_sceen_items.*

/**
 * @author robin
 * Created on 6/3/20
 */
class ResourceFragment(private val items : List<Item>) : Fragment() {
    private val resourceAdapter = ResourceAdapter<PeopleResponse>()

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
        viewModel.peoplePagedList.observe(viewLifecycleOwner, Observer {
            resourceAdapter.submitList(it)
        })

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}