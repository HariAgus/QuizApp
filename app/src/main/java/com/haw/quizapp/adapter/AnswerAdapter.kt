package com.haw.quizapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haw.quizapp.R
import com.haw.quizapp.databinding.ItemAnswerBinding
import com.haw.quizapp.model.Answer

class AnswerAdapter : RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

    private var answers = mutableListOf<Answer>()

    fun setData(answer: MutableList<Answer>) {
        this.answers = answers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = answers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(answers[position])
    }

    inner class ViewHolder(private val binding: ItemAnswerBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(answer: Answer) {
            binding.tvOption.text = answer.option
            binding.tvAnswer.text = answer.answer

            if (answer.isClick!!) {
                activeCheckAnswer()
            } else {
                inActiveCheckAnswer()
            }

            itemView.setOnClickListener {
                for (i in 0 until answers.size) {
                    if (i == adapterPosition) {
                        answers[i].isClick = true
                    } else {
                        answers[i].isClick = true
                    }
                }
                notifyDataSetChanged()
            }
        }

        private fun activeCheckAnswer() {
            binding.ivCheckAnswer.setImageResource(R.drawable.ic_baseline_check_circle_24)
        }

        private fun inActiveCheckAnswer() {
            binding.ivCheckAnswer.setImageResource(R.drawable.ic_baseline_panorama_fish_eye_24)
        }

    }
}