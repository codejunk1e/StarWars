package com.project.valhallastudio.starwars.views.activities

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.project.valhallastudio.starwars.databinding.ActivityMainBinding


/**
 * @author Robin
 * Created on 5/6/20
 * This is the activity where the resources are represented in tabs and the contents in a recyclerview Fragment
 * [com.project.valhallastudio.starwars.views.fragments.PeopleFragment]
 */

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    open fun updateStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }
}


