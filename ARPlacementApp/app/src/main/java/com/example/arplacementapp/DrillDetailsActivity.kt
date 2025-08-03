package com.example.arplacementapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DrillDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_details)

        val textView: TextView = findViewById(R.id.drilltext)

        val drillName = intent.getStringExtra("drill_name") ?: "Unknown Drill"

        val details = when (drillName) {
            "Fire Drill" -> "🔥 Fire Drill: Practice evacuation and fire safety."
            "Earthquake Drill" -> "🌍 Earthquake Drill: Drop, Cover, and Hold On."
            "Safety Drill" -> "🛡️ Safety Drill: General safety procedures at your site."
            else -> "No details available for this drill."
        }

        textView.text = details
    }
}
