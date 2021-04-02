package com.haw.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haw.quizapp.databinding.ItemContentBinding
import com.haw.quizapp.model.Answer
import com.haw.quizapp.model.Content

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    private var contents = mutableListOf<Content>()

    fun setData(contents: MutableList<Content>) {
        this.contents = contents
        notifyDataSetChanged()
    }

    fun getResults(): MutableList<Content> {
        return contents
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(contents[position])
    }

    class ViewHolder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(content: Content) {
            val answerAdapter = AnswerAdapter()

            binding.tvQuiz.text = content.body
            binding.ivQuiz.visibility = View.GONE

            if (content.image != null && content.image.isNotEmpty()) {
                binding.ivQuiz.visibility = View.VISIBLE
                Glide.with(itemView)
                    .load(content.image)
                    .placeholder(android.R.color.darker_gray)
                    .into(binding.ivQuiz)
            } else {
                binding.ivQuiz.visibility = View.GONE
            }

            if (content.answers != null) {
                answerAdapter.setData(content.answers as MutableList<Answer>)
                binding.rvAnswerQuiz.adapter = answerAdapter
            }
        }
    }

}