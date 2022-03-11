package com.example.devthink.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devthink.databinding.ItemCommunityContentBinding

class QuestionRVAdapter(private val contentList: ArrayList<Content>) : RecyclerView.Adapter<QuestionRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): QuestionRVAdapter.ViewHolder {
        val binding: ItemCommunityContentBinding = ItemCommunityContentBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionRVAdapter.ViewHolder, position: Int) {
        holder.bind(contentList[position])
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    inner class ViewHolder(val binding: ItemCommunityContentBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(content: Content) {
            binding.communityTitleTv.text = content.title
            binding.communityDateTv.text = content.date
            binding.communityNicknameTv.text = content.nickname
            binding.communityLikeTv.text = content.like.toString()
        }

    }

}