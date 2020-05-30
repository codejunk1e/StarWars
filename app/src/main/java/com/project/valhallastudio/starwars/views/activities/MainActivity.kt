package com.project.valhallastudio.starwars.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.valhallastudio.starwars.databinding.ActivityMainBinding
import com.project.valhallastudio.starwars.responsemodels.RootResponse
import com.project.valhallastudio.starwars.views.adapters.StarPagerAdapter
import com.project.valhallastudio.starwars.webservice.StarWarsService
import com.project.valhallastudio.starwars.webservice.StarWarsService.Companion.API_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Robin
 * Created on 5/6/20
 * This is the activity where the resources are represented in tabs and the contents in a recyclerview Fragment
 * [com.project.valhallastudio.starwars.views.fragments.ResourceContentFragment]
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val starPagerAdapter = StarPagerAdapter(this)
        binding.viewpagerMain.adapter = starPagerAdapter

        val response: Call<RootResponse> = StarWarsService.getInstance().getRootResponse(API_URL);
        response.enqueue(
            object : Callback<RootResponse> {
                override fun onFailure(call: Call<RootResponse>, t: Throwable) {

                    Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(
                    call: Call<RootResponse>,
                    response: Response<RootResponse>
                ) {

                    Toast.makeText(this@MainActivity, "Response", Toast.LENGTH_SHORT).show()

                }

            }
        )


    }


}
