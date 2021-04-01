package com.haw.quizapp.ui.content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haw.quizapp.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}