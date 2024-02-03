package com.example.foodorderingapplication.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.foodorderingapplication.R

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            startActivity(Intent(this , MainActivity::class.java))
        }

    }
}