package com.haw.quizapp.ui.screen.prepare

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.haw.quizapp.R
import com.haw.quizapp.ui.screen.content.ContentActivity
import com.haw.quizapp.utils.startActivity

class PrepareActivity : AppCompatActivity() {

    private var nickname by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrepareScreen(
                nickname = nickname,
                onValueChange = {
                    nickname = it
                },
                onClickStart = {
                    if (checkValidation(nickname)) {
                        startActivity<ContentActivity>(
                            ContentActivity.EXTRA_NICKNAME to nickname
                        )
                    }
                }
            )
        }
    }

    private fun checkValidation(nickname: String): Boolean {
        return if (nickname.isEmpty()) {
            Toast.makeText(
                this,
                getString(R.string.please_field_your_nickname),
                Toast.LENGTH_SHORT
            ).show()
            false
        } else {
            true
        }
    }
}