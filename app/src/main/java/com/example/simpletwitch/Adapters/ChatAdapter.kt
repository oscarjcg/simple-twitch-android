package com.example.simpletwitch.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpletwitch.Activities.ChannelActivity
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.Models.Comment
import com.example.simpletwitch.R

class ChatAdapter(private val data: ArrayList<Comment>, private val activity: ChannelActivity)
    : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val author: TextView = view.findViewById(R.id.author)
        val container: ConstraintLayout = view.findViewById(R.id.container)
        val comment: TextView = view.findViewById(R.id.comment)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_viewholder, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val comment = data[position]
        holder.author.text = comment.author + ": "
        holder.comment.text = comment.comment


    }

    override fun getItemCount(): Int {
        return data.size
    }
}