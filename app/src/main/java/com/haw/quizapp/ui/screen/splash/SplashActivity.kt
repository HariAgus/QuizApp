package com.haw.quizapp.ui.screen.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.haw.quizapp.ui.screen.main.MainActivity
import com.haw.quizapp.utils.startActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }

        delayAndGoToMain()
    }

    private fun delayAndGoToMain() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity<MainActivity>()
            finishAffinity()
        }, 1600)
    }
}