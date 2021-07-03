package com.example.simpletwitch.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpletwitch.Activities.CHANNEL_ID
import com.example.simpletwitch.Activities.ChannelActivity
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Models.Channel
import com.example.simpletwitch.R

class ChannelAdapter(private val data: ArrayList<Channel>, private val activity: MainActivity,
    private val useBigView: Boolean = false)
    : RecyclerView.Adapter<ChannelAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val container: ConstraintLayout = view.findViewById(R.id.container)
        val preview: ImageView = view.findViewById(R.id.preview)
        val image: ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = if (useBigView) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.big_channel_viewholder, parent, false)
        } else {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.channel_viewholder, parent, false)
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val channel = data[position]

        holder.name.text = channel.name
        //holder.preview.setImageResource(R.drawable.video_player)
        Glide.with(holder.preview)
                .load(channel.preview)
                .into(holder.preview)

        //holder.image.setImageResource(R.drawable.avatar)
        Glide.with(holder.image)
                .load(channel.image)
                .into(holder.image)

        holder.container.setOnClickListener {
            val intent = Intent(activity, ChannelActivity::class.java).apply {
                putExtra(CHANNEL_ID, channel.id)
            }
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}