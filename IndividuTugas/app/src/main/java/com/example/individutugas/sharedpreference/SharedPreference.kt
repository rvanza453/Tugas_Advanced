package com.example.individutugas.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.individutugas.databinding.ActivityMainBinding
import com.example.individutugas.databinding.ActivitySharedPreferenceBinding

class MainActivity : AppCompatActivity() {

    private val PREF_NAME = "MyPreferences"
    private val KEY_USERNAME = "username"
    private lateinit var binding: ActivitySharedPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val savedUsername = sharedPreferences.getString(KEY_USERNAME, "")

        binding.textView.text = "Saved Username: $savedUsername"

        binding.saveButton.setOnClickListener {
            val username = binding.editText.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString(KEY_USERNAME, username)

            editor.apply()

            binding.textView.text = "Saved Username: $username"
        }
    }
}
