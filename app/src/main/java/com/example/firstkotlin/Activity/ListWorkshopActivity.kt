package com.example.firstkotlin.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.firstkotlin.ActorAdapter
import com.example.firstkotlin.R
import com.example.firstkotlin.generateActors

class ListWorkshopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_workshop)

        val list = findViewById<RecyclerView>(R.id.list)

        val actors = generateActors()
        val adapter = ActorAdapter(this, actors)

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
    }
}