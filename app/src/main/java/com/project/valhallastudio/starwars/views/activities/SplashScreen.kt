package com.project.valhallastudio.starwars.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.valhallastudio.starwars.R

/**
 * @author Robin
 * Created on 5/6/20
 */

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setImmersiveMode()
        scheduleSplashScreen()
    }
    private fun setImmersiveMode() {
        window.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


    private fun scheduleSplashScreen() {
        val splashScreenDuration = getSplashScreenDuration()

        Handler().postDelayed({
            startActivity(Intent(this,
                MainActivity::class.java))
            finish()
        }, splashScreenDuration)

    }
    private fun getSplashScreenDuration() = 2400L
}