package com.example.igdb.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.igdb.R
import com.example.igdb.views.Typewriter

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        showAnimatedTitle("IGDB")

    }

    private fun showAnimatedTitle(splashTitle: String) {
        val writer = findViewById<Typewriter>(R.id.splashTitle)
        writer.animateText(splashTitle)
    }
}
