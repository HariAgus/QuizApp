package com.haw.quizapp.ui.screen.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.haw.quizapp.R
import com.haw.quizapp.ui.screen.main.MainActivity
import com.haw.quizapp.utils.startActivity

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