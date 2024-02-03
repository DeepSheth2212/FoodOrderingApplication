package com.example.foodorderingapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.foodorderingapplication.Domain.CategoryDomain
import com.example.foodorderingapplication.R

class CategoryAdapter(val context : Context , val categoryList: MutableList<CategoryDomain>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : ViewHolder(itemView){
        val categoryPic = itemView.findViewById<ImageView>(R.id.categoryPic)
        val categoryText = itemView.findViewById<TextView>(R.id.categoryText)
        val mainLayout = itemView.findViewById<ConstraintLayout>(R.id.mainLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryText.text = categoryList[position].title
        var picUrl =""
        when(position){
            0 -> {
                picUrl = "cat_1"
                holder.mainLayout.setBackground(ContextCompat.getDrawable(context,R.drawable.cat_background1))
            }
            1 -> {
                picUrl = "cat_2"
                holder.mainLayout.setBackground(ContextCompat.getDrawable(context,R.drawable.cat_background2))
            }
            2 -> {
                picUrl = "cat_3"
                holder.mainLayout.setBackground(ContextCompat.getDrawable(context,R.drawable.cat_background3))
            }
            3 -> {
                picUrl = "cat_4"
                holder.mainLayout.setBackground(ContextCompat.getDrawable(context,R.drawable.cat_background4))
            }
            4 -> {
                picUrl = "cat_5"
                holder.mainLayout.setBackground(ContextCompat.getDrawable(context,R.drawable.cat_background5))
            }
        }

        val resourceId = context.resources.getIdentifier(picUrl,"drawable",context.packageName)

        Glide.with(context)
            .load(resourceId)
            .into(holder.categoryPic)

    }
}