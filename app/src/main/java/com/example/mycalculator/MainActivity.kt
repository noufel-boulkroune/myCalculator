package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvInput = findViewById(R.id.tvInput)
    }


    fun onDigit(view: View) {
//            Toast.makeText(
//                this, "Button Clicked", Toast.LENGTH_LONG
//
//            ).show()
        if ((view as Button).text == "CLR") {

            tvInput?.text = ""
        } else {


            tvInput?.append((view as Button).text)
        }


    }
}