package com.example.lifehackquiz


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcombat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityDebug"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        log.d(TAG, "Welcome screen loaded successfully.")
        
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            log.i(TAG, "Start button clicked. Navigating to QuizActivity.")
            val intent = Intent(this, QuizActivity: :class.java)
            startActivity(intent)
        }
        
    }
}
