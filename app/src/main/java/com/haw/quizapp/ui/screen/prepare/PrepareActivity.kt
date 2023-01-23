package com.haw.quizapp.ui.screen.prepare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haw.quizapp.R
import com.haw.quizapp.databinding.ActivityPrepareBinding
import com.haw.quizapp.ui.screen.content.ContentActivity
import com.haw.quizapp.utils.startActivity

class PrepareActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrepareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrepareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        binding.btnStart.setOnClickListener {
            val nickname = binding.etNickname.text.toString().trim()

            if (checkValidation(nickname)) {
                startActivity<ContentActivity>(
                    ContentActivity.EXTRA_NICKNAME to nickname
                )
            }
        }
    }

    private fun checkValidation(nickname: String): Boolean {
        return if (nickname.isEmpty()) {
            binding.etNickname.error = getString(R.string.please_field_your_nickname)
            false
        } else {
            true
        }
    }
}