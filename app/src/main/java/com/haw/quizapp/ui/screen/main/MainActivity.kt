package com.haw.quizapp.ui.screen.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.haw.quizapp.ui.screen.prepare.PrepareActivity
import com.haw.quizapp.utils.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen {
                startActivity<PrepareActivity>()
            }
        }
    }

}