package com.project.valhallastudio.starwars.views.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.project.valhallastudio.starwars.R

/**
 * @author Robin
 * Created on 5/6/20
 * A simple [Fragment] to show the splash Screen the ugly way.
 */
class SplashFragment : Fragment() {
    private fun getSplashScreenDuration() = 2400L


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {

        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
        }, getSplashScreenDuration())

    }
}
