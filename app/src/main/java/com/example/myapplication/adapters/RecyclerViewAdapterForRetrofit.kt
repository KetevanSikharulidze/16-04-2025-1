package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.RetrofitItemBinding
import com.example.myapplication.models.PostListItem

class RecyclerViewAdapterForRetrofit(private val posts: List<PostListItem>) :
    RecyclerView.Adapter<RecyclerViewAdapterForRetrofit.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RetrofitItemBinding.bind(itemView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.retrofit_item, parent, false)
        return PostViewHolder(view)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.binding.apply {
            titleText.text = post.title
            userID.text = post.id.toString()
            bodyText.text = post.body
        }
    }
    override fun getItemCount(): Int = posts.size
}