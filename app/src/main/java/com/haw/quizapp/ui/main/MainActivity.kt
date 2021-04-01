package com.haw.quizapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haw.quizapp.R
import com.haw.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        onClick()
    }

    private fun onClick() {
        mainBinding.btnPlay.setOnClickListener {

        }
    }
}