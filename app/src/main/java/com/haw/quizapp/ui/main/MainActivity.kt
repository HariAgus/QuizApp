package com.haw.quizapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haw.quizapp.databinding.ActivityMainBinding
import com.haw.quizapp.ui.prepare.PrepareActivity
import com.haw.quizapp.utils.startActivity

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
            startActivity<PrepareActivity>()
        }
    }
}