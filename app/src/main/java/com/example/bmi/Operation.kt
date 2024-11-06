package com.example.bmi

import android.content.Context
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
    
    fun inputValidation(context: Context, inputWeight: EditText, inputHeight: EditText): Boolean {

        val h = inputHeight.text.toString()
        val w = inputWeight.text.toString()
        
        if (w.isEmpty() && h.isNotEmpty()) {
            Toast.makeText(
                context,
                (context.getString(R.string.input_data_height_text)),
                Toast.LENGTH_SHORT).show()
            return false
        }

        if (w.isNotEmpty() && h.isEmpty()) {
            Toast.makeText(
                context,
                (context.getString(R.string.input_data_weight_text)),
                Toast.LENGTH_SHORT).show()
            return false
        }

        if (h.isEmpty() || w.isEmpty()) {
            Toast.makeText(
                context,
                context.getString(R.string.input_data_text),
                Toast.LENGTH_SHORT).show()
            return false
        }

        val weight = w.toInt()
        val height = h.toInt()

        if (height !in 50..250) {
            Toast.makeText(
                context,
                context.getString(R.string.validate_input_height_text),
                Toast.LENGTH_SHORT)
                .show()
            return false
        }

        if (weight !in 5..500) {
            Toast.makeText(
                context,
                context.getString(R.string.validate_input_weight_text),
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        return true
    }

    fun cleanET(weightET: EditText, heightET: EditText) {
        weightET.setOnClickListener {
            weightET.setText("")
        }

        heightET.setOnClickListener {
            heightET.setText("")
        }
    }
}