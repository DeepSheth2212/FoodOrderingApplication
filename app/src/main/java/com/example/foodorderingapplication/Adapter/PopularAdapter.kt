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
import com.example.foodorderingapplication.Domain.FoodDomain
import com.example.foodorderingapplication.R

class PopularAdapter(val context : Context, val foodList: MutableList<FoodDomain>) : RecyclerView.Adapter<PopularAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : ViewHolder(itemView){
        val pic = itemView.findViewById<ImageView>(R.id.pic)
        val title = itemView.findViewById<TextView>(R.id.populatItemTitle)
        val fee = itemView.findViewById<TextView>(R.id.fee)
        val addBtn = itemView.findViewById<TextView>(R.id.addBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.popular_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.title.text = foodList[position].title
        holder.fee.text = foodList[position].fee.toString()


        val resourceId = context.resources.getIdentifier(foodList[position].pic,"drawable",context.packageName)

        Glide.with(context)
            .load(resourceId)
            .into(holder.pic)

    }
}