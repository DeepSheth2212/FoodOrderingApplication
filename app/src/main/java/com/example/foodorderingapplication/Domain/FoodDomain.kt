package com.example.foodorderingapplication.Domain

data class FoodDomain(
    val title: String ,
    val pic : String,
    val description : String,
    val fee : Double,
    val numberInCart : Int = 0
    )
