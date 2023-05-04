package com.azimzada.spinnerlesson

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.azimzada.spinnerlesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var list = mutableListOf<String>("Baku", "Masalli", "Lenkeran", "Astara", "Seki")
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list)
        spinner.adapter = adapter

        sharedPreferences = getSharedPreferences("Person", MODE_PRIVATE)
        setUpClickListeners()
        getData()
    }

    fun setUpClickListeners() {
        binding.button.setOnClickListener {
            save()
        }
    }

    fun save() {
        val personName = binding.inputTv.text.toString()
        sharedPreferences.edit().putString("PersonName", personName).apply()
    }

    //
    fun getData() {
        val savedData = sharedPreferences.getString("PersonName", " ")
        binding.inputTv.setText(savedData)
    }

}