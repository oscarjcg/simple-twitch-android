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
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.R

class CategoryAdapter(private val data: ArrayList<Category>, private val activity: MainActivity)
    : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val container: ConstraintLayout = view.findViewById(R.id.container)
        val image: ImageView = view.findViewById(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_viewholder, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val category = data[position]
        holder.name.text = category.name

        Glide.with(holder.image)
            .load(category.image)
            .into(holder.image)



        holder.container.setOnClickListener {
            Toast.makeText(activity, "Category $position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}