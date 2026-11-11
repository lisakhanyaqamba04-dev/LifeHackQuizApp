package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    private val TAG = "WelcomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        Log.d(TAG, "Welcome screen created")

        val startButton: Button = findViewById(R.id.btnStart)

        startButton.setOnClickListener {
            Log.i(TAG, "Start button clicked, navigating to QuizActivity")
            // Navigate to the Question Screen
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}
