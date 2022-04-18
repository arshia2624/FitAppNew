package com.example.fitimdiaapp.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.fitimdiaapp.MainActivity
import com.example.fitimdiaapp.R

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startHandler()
    }

    fun startHandler() {
        Handler(Looper.getMainLooper()).postDelayed({
            gotoNextScreen()
            // Your Code
        }, 3000)
    }

    private fun gotoNextScreen() {
        run {
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}