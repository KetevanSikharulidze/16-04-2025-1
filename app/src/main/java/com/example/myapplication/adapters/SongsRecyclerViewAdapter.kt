package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.SongItemBinding
import com.example.myapplication.models.Song


class SongsRecyclerViewAdapter : ListAdapter<Song,SongsRecyclerViewAdapter.Holder>(Comparator()) {

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = SongItemBinding.bind(itemView)
        fun bind(item: Song) = with(binding){
            songName.text = item.name
            songDescription.text = item.description
            Glide.with(root).load(item.cover).into(songIV)
        }
    }

    class Comparator() : DiffUtil.ItemCallback<Song>(){
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}