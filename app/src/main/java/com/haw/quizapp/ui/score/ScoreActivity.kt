package com.haw.quizapp.ui.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haw.quizapp.databinding.ActivityScoreBinding
import com.haw.quizapp.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class ScoreActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SCORE = "extra_score"
    }

    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get Data
        if (intent != null) {
            val score = intent.getIntExtra(EXTRA_SCORE, 0)
            val nickname = intent.getStringExtra(EXTRA_NAME)

            binding.tvNickname.text = nickname
            binding.tvScore.text = score.toString()
        }

        onClick()
    }

    private fun onClick() {
        binding.btnScoreDone.setOnClickListener {
            startActivity<MainActivity>()
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity<MainActivity>()
        finishAffinity()
    }
}