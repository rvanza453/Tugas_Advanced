package com.example.individutugas.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.individutugas.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            ItemModel("Revanza", "08233388559"),
            ItemModel("Daffa", "08123213345"),
            ItemModel("Ayyash","085738998224")
        )

        val adapter = MyAdapter(itemList)
        recyclerView.adapter = adapter
    }
}
