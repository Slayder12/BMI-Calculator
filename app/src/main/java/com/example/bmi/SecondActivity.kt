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

        if (bmi.toDouble() <= 18.49) {
            bodyImageIV.setImageResource(R.drawable.underweight)
            referencesTextTV.text = Database().underweightRefText
        } else if (bmi.toDouble() in 18.5 .. 24.99) {
            bodyImageIV.setImageResource(R.drawable.normal)
            referencesTextTV.text = Database().normalRefText
        } else if (bmi.toDouble() in 25.0..29.99) {
            bodyImageIV.setImageResource(R.drawable.overweight)
            referencesTextTV.text = Database().overweightRefText
        } else if (bmi.toDouble() in 30.0..34.99) {
            bodyImageIV.setImageResource(R.drawable.obese)
            referencesTextTV.text = Database().obeseRefText
        } else if (bmi.toDouble() >= 35.0) {
            bodyImageIV.setImageResource(R.drawable.extrem_obese)
            referencesTextTV.text = Database().extremalObeseText
        }
    }

}