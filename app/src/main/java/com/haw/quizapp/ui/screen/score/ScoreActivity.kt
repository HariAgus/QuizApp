package com.haw.quizapp.ui.screen.score

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.haw.quizapp.ui.screen.main.MainActivity
import com.haw.quizapp.utils.startActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Get Data
            if (intent != null) {
                val score = intent.getIntExtra(EXTRA_SCORE, 0)
                val nickname = intent.getStringExtra(EXTRA_NAME)

                ScoreScreen(
                    nickname = nickname.toString(),
                    score = score.toString(),
                    onClickDone = {
                        onClickDone()
                    }
                )
            }
        }

    }

    private fun onClickDone() {
        startActivity<MainActivity>()
        finishAffinity()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity<MainActivity>()
        finishAffinity()
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SCORE = "extra_score"
    }

}