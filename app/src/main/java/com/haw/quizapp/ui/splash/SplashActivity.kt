package com.haw.quizapp.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.haw.quizapp.R
import com.haw.quizapp.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delayAndGoToMain()
    }

    private fun delayAndGoToMain() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity<MainActivity>()
        }, 1200)
    }
}