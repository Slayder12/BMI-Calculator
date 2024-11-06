package com.example.bmi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var bmiResultTV: TextView
    private lateinit var bodyImageIV: ImageView
    private lateinit var referencesTextTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        bmiResultTV = findViewById(R.id.bmiResultTV)
        bodyImageIV = findViewById(R.id.bodyImageIV)
        referencesTextTV = findViewById(R.id.referencesTextTV)

        val weight = intent.getStringExtra("weight").toString().toInt()
        val height = intent.getStringExtra("height").toString().toInt()
        val bmi = Operation().calculateBmi(weight, height)
        bmiResultTV.text = "ИМТ = $bmi"

        Operation().result(bmi, bodyImageIV, referencesTextTV)
    }

}