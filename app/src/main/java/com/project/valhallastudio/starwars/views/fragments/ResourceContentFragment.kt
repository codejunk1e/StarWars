package com.project.valhallastudio.starwars.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.project.valhallastudio.starwars.R
import com.project.valhallastudio.starwars.databinding.FragmentResourceContentBinding

/**
 * @author Robin
 * Created on 5/6/20
 * A simple Fragment that represents the resources contents in a simple Recyclerview
 */
class ResourceContentFragment : Fragment() {
    companion object{

    }

    private var _binding: FragmentResourceContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {
        _binding = FragmentResourceContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
