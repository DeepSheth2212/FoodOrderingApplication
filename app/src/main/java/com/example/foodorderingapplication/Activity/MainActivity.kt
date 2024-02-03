package com.example.foodorderingapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.foodorderingapplication.Adapter.CategoryAdapter
import com.example.foodorderingapplication.Adapter.PopularAdapter
import com.example.foodorderingapplication.Domain.CategoryDomain
import com.example.foodorderingapplication.Domain.FoodDomain

import com.example.foodorderingapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewCategoryList : RecyclerView
    private lateinit var adapter: Adapter<CategoryAdapter.CategoryViewHolder>
    private lateinit var recyclerViewPopularList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewCategory()
        popularCategory()
    }

    private fun recyclerViewCategory() {
        recyclerViewCategoryList = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewCategoryList.layoutManager = linearLayoutManager

        val category = mutableListOf<CategoryDomain>()
        category.add(CategoryDomain("Pizza","cat_1"))
        category.add(CategoryDomain("Burger","cat_2"))
        category.add(CategoryDomain("Hot dog","cat_3"))
        category.add(CategoryDomain("Drink","cat_4"))
        category.add(CategoryDomain("Donut","cat_5"))

        adapter = CategoryAdapter(this,category)
        recyclerViewCategoryList.adapter= adapter

    }

    private fun popularCategory(){
        recyclerViewPopularList = findViewById(R.id.recyclerView2)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewPopularList.layoutManager = linearLayoutManager

        val foodList = mutableListOf<FoodDomain>()
        foodList.add(FoodDomain("Pepperoni Pizza","pop_1","slices pepperoni, mozerella cheese, fresh oregano, ground black pepper, pizza sauce", 9.76))

        foodList.add(FoodDomain("Cheese Burger","pop_2","slices pepperoni, mozerella cheese, fresh oregano, ground black pepper, pizza sauce", 9.76))

        foodList.add(FoodDomain("Vegetable Pizza","pop_3","slices pepperoni, mozerella cheese, fresh oregano, ground black pepper, pizza sauce", 9.76))

        val adapter2 = PopularAdapter(this,foodList)
        recyclerViewPopularList.adapter = adapter2

    }
}