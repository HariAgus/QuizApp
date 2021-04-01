package com.haw.quizapp.ui.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haw.quizapp.databinding.ActivityScoreBinding
import com.haw.quizapp.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        binding.btnScoreDone.setOnClickListener {
            startActivity<MainActivity>()
        }
    }
}