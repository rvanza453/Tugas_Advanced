package com.example.individutugas.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.individutugas.databinding.ActivityViewModelBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIncrement.setOnClickListener {
            viewModel.increment()
            updateCount(binding)
        }

        binding.btnDecrement.setOnClickListener {
            viewModel.decrement()
            updateCount(binding)
        }

        updateCount(binding)
    }

    private fun updateCount(binding: ActivityViewModelBinding) {
        binding.tvCount.text = viewModel.count.toString()
    }
}
