package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var weightET: EditText
    private lateinit var heightET: EditText
    private lateinit var calculateBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightET = findViewById(R.id.weightET)
        heightET = findViewById(R.id.heightET)
        calculateBTN = findViewById(R.id.calculateBTN)

        calculateBTN.setOnClickListener {
            if (!Operation().inputValidation(weightET, heightET)) return@setOnClickListener
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("weight", weightET.text.toString())
            intent.putExtra("height", heightET.text.toString())
            launchActivity.launch(intent)
        }

        weightET.setOnClickListener() {
            weightET.setText("")
        }

        heightET.setOnClickListener() {
            heightET.setText("")
        }

    }

    private val launchActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { _ -> }

}