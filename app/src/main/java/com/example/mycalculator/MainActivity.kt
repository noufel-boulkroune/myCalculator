package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    var lastNumeric : Boolean = false
    var lastDot : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvInput = findViewById(R.id.tvInput)
    }


    fun onDigit(view: View) {
        lastNumeric = true
        lastDot = false
//            Toast.makeText(
//                this, "Button Clicked", Toast.LENGTH_LONG
//
//            ).show()
        if ((view as Button).text == "CLR") {
            lastDot = false
            lastNumeric = false

            tvInput?.text = ""
        } else {


            tvInput?.append((view as Button).text)
        }


    }

    fun onDecimalePoint(view: View){
        if (lastNumeric && !lastDot){
            tvInput?.append(".")
            lastDot = true
            lastNumeric = false
        }

    }


    fun onOperatot(view: View){
        tvInput?.text?.let {
            println(lastNumeric)
            if (lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual(view: View){
        if (lastNumeric){
            var tvValue = tvInput?.text.toString()
            var prefix = ""


            try{
                if(tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)

                }
                if(tvValue.contains("-")){

                    val  splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                        if(prefix.isNotEmpty()){
                            one = prefix + one
                        }
                    tvInput?.text = (one.toDouble() - two.toDouble()).toString()

                }else   if(tvValue.contains("+")){

                    val  splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvInput?.text = (one.toDouble() + two.toDouble()).toString()

                }else   if(tvValue.contains("/")){

                    val  splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvInput?.text = (one.toDouble() / two.toDouble()).toString()

                }else   if(tvValue.contains("*")){

                    val  splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvInput?.text = (one.toDouble() * two.toDouble()).toString()

                }



            }catch (e: ArithmeticException){
                println(e)
                e.printStackTrace()
            }
        }
    }

    private fun isOperatorAdded(value :String) : Boolean {
        return  if(value.startsWith("-")){
            false
        }else{
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}