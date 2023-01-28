package com.haw.quizapp.ui.screen.content

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.haw.quizapp.R
import com.haw.quizapp.adapter.ContentAdapter
import com.haw.quizapp.databinding.ActivityContentBinding
import com.haw.quizapp.model.Content
import com.haw.quizapp.repository.Repository
import com.haw.quizapp.ui.screen.main.MainActivity
import com.haw.quizapp.ui.screen.score.ScoreActivity
import com.haw.quizapp.utils.startActivity

class ContentActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NICKNAME = "extra_nickname"
        const val EXTRA_CONTENTS = "extra_contents"
    }

    private lateinit var binding: ActivityContentBinding
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private var dataSize = 0
    private var currentPosition = 0
    private var nickname: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Init
        contentAdapter = ContentAdapter()

        //Get Data
        if (intent != null) {
            nickname = intent.getStringExtra(EXTRA_NICKNAME)
        }

        if (savedInstanceState != null) {
            nickname = savedInstanceState.getString(EXTRA_NICKNAME)
            val contents = savedInstanceState.getParcelableArrayList<Content>(EXTRA_CONTENTS)
            showDataContents(contents)
        } else {
            //Get data from Repository
            val contents = Repository.getDataContents(this)
            showDataContents(contents)
        }

        //On Click
        onClick()
    }

    private fun onClick() {
        binding.btnBack.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.are_you_sure))
                .setMessage(getString(R.string.message_exit))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    dialog.dismiss()
                    startActivity<MainActivity>()
                    finishAffinity()
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.btnNextContent.setOnClickListener {
            if (currentPosition < dataSize - 1) {
                binding.rvContent.smoothScrollToPosition(currentPosition + 1)
            } else {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.are_you_sure))
                    .setMessage(getString(R.string.message_input_data))
                    .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                        val contents = contentAdapter.getResults()
                        val totalQuiz = contents.size
                        var totalCorrectAnswer = 0

                        for (content in contents) {
                            for (answer in content.answers!!) {
                                if (answer.isClick == true && answer.correctAnswer == true) {
                                    totalCorrectAnswer += 1
                                }
                            }
                        }

                        val totalScore = totalCorrectAnswer.toDouble() / totalQuiz * 100

                        startActivity<ScoreActivity>(
                            ScoreActivity.EXTRA_NAME to nickname,
                            ScoreActivity.EXTRA_SCORE to totalScore.toInt()
                        )
                        dialog.dismiss()
                    }
                    .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }

        binding.btnPrevContent.setOnClickListener {
            binding.rvContent.smoothScrollToPosition(currentPosition - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_NICKNAME, nickname)
        val contents = contentAdapter.getResults()
        outState.putParcelableArrayList(EXTRA_CONTENTS, contents as ArrayList)
    }

    private fun showDataContents(contents: List<Content>?) {
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = PagerSnapHelper()

        if (contents != null) {
            contentAdapter.setData(contents as MutableList<Content>)
        }

        snapHelper.attachToRecyclerView(binding.rvContent)
        binding.rvContent.layoutManager = layoutManager
        binding.rvContent.adapter = contentAdapter

        dataSize = layoutManager.itemCount
        binding.pbContent.max = dataSize - 1

        //First show Index
        var index = "${currentPosition + 1} / $dataSize"
        binding.tvIndexContent.text = index

        binding.rvContent.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentPosition = layoutManager.findFirstVisibleItemPosition()
                index = "${currentPosition + 1} / $dataSize"
                binding.tvIndexContent.text = index
                binding.pbContent.progress = currentPosition
            }
        })
    }
}