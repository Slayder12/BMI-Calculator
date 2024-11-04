package com.example.bmi

import android.widget.EditText
import android.widget.Toast
import java.text.DecimalFormat

class Operation {

    fun calculateBmi(weight: Int, height: Int): String {
        val bmi: Double = weight.toString().toDouble() / ((height.toString().toDouble() / 100) * (height.toString().toDouble() / 100))
        val decimalFormat = DecimalFormat("#.0")
        val result = decimalFormat.format(bmi)
        return result
    }
    
    fun inputValidation(inputWeight: EditText, inputHeight: EditText): Boolean {
        val w = inputWeight.text.toString()
        val h = inputHeight.text.toString()
        if (w.isNotEmpty() && h.isNotEmpty()) {
            val weight = w.toInt()
            val height = h.toInt()

            if (weight in 5..500 && height in 50..250) {
                return true
            } else {
                Toast.makeText(
                    inputWeight.context,
                    inputWeight.context.getString(R.string.validate_input_text),
                    Toast.LENGTH_SHORT).show()
                return false
            }
        }
        Toast.makeText(
            inputWeight.context,
            inputWeight.context.getString(R.string.input_data_text), 
            Toast.LENGTH_SHORT).show()
        return false
    }
}