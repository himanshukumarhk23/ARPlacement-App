package com.example.arplacementapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arplacementapp.R


class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var btnStart: Button
    private lateinit var btnViewDetails: Button
    private var selectedDrill: String = "Fire Drill" // Default value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        btnStart = findViewById(R.id.btnStart)
        btnViewDetails = findViewById(R.id.btnViewDetails)

        // 📌 Spinner Drill Selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                selectedDrill = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional
            }
        }

        // 📌 Start AR Button Click
        btnStart.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            intent.putExtra("drill_name", selectedDrill)
            startActivity(intent)
        }

        // 📌 View Details Button Click (Optional)
        btnViewDetails.setOnClickListener {
            val intent = Intent(this, DrillDetailsActivity::class.java)
            intent.putExtra("drill_name", selectedDrill)
            startActivity(intent)
        }
    }
}
