package com.example.firstkotlin.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.firstkotlin.R

class MainActivity : AppCompatActivity() {
    private var count = 0
    private var textView: TextView? = null
    private var buttonView: Button? = null
    private var buttonGoSecond: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Information", "on Create")



        textView = findViewById<TextView>(R.id.textView).apply {
            text = "The value is :$count"
        }

        buttonView = findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                count++
                textView?.text = "The value is: $count"
            }
        }
        buttonGoSecond = findViewById<Button>(R.id.button2).apply {
            setOnClickListener {
                startActivity(Intent(context, SecondActivity::class.java))
            }
        }

        findViewById<Button>(R.id.buttonForListWorkshop).apply {
            setOnClickListener {
                startActivity(Intent(context, ListWorkshopActivity::class.java))
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_ARGUMENT, count)
        Log.d("info", "onSaveInstanceState - count is: $count")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(COUNT_ARGUMENT, 0)
        Log.d("info", "count is: $count")
        textView?.text = "The value is: $count"

    }

    companion object {
        private const val COUNT_ARGUMENT = "CountArgument"
    }
}