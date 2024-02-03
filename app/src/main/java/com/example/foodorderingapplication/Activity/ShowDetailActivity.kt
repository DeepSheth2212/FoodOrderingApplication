package com.example.foodorderingapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.foodorderingapplication.Domain.FoodDomain

import com.example.foodorderingapplication.R


class ShowDetailActivity : AppCompatActivity() {
    private lateinit var addToCartBtn : TextView
    private lateinit var titleTxt : TextView
    private lateinit var priceTxt : TextView
    private lateinit var descriptionTxt : TextView
    private lateinit var numberOrderTxt : TextView
    private lateinit var plusBtn : ImageView
    private lateinit var minusBtn : ImageView
    private lateinit var picFood : ImageView
    private lateinit var obj  : FoodDomain
    var numberOrder = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        initView()
        getBundle()
    }

    private fun getBundle() {
        obj = intent.getSerializableExtra("object") as FoodDomain
        val drawableResourceId = this.resources.getIdentifier(obj.pic,"drawable",this.packageName)
        Glide.with(this).load(drawableResourceId).into(picFood)
        titleTxt.text = obj.title
        priceTxt.text = "$ "+obj.fee
        descriptionTxt.text = obj.description
        numberOrderTxt.text = numberOrder.toString()

        plusBtn.setOnClickListener {
            numberOrder++
            numberOrderTxt.text= numberOrder.toString()
        }

        minusBtn.setOnClickListener {
            if(numberOrder>1){
                numberOrder--;
                numberOrderTxt.text = numberOrder.toString()
            }

        }
    }

    private fun initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn)
        plusBtn = findViewById(R.id.plusBtn)
        minusBtn = findViewById(R.id.minusBtn)
        numberOrderTxt = findViewById(R.id.orderNumberTxt)
        picFood = findViewById(R.id.picFood)
        descriptionTxt = findViewById(R.id.descriptionTxt)
        priceTxt = findViewById(R.id.priceTxt)
        titleTxt = findViewById(R.id.titleTxt)

    }
}