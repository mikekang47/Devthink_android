package com.example.devthink.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devthink.databinding.ItemCommunityContentBinding
import com.example.devthink.databinding.ItemProjectBinding

class ProjectRVAdapter(private val projectList: ArrayList<Project>) : RecyclerView.Adapter<ProjectRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProjectRVAdapter.ViewHolder {
        val binding: ItemProjectBinding = ItemProjectBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectRVAdapter.ViewHolder, position: Int) {
        holder.bind(projectList[position])
    }

    override fun getItemCount(): Int {
        return projectList.size
    }

    inner class ViewHolder(val binding: ItemProjectBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(project: Project) {

            binding.itemProjectNameTv.text = project.title
            binding.itemProjectNumTv.text = "인원: "+project.num+"명"
            binding.itemProjectJobTv.text = "모집직무: "+project.job
            binding.itemProjectDeadlineTv.text = project.date+"까지"
            binding.itemProjectNicknameTv.text = project.nickname
        }

    }

}