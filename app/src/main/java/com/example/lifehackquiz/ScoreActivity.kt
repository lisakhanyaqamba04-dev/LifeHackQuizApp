package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = "ScoreActivityDebug"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        
        val score = intent.getIntExtra("USER_SCORE", 0)
        val total = intent.getIntExtra("TOTAL_QUESTIONS", 4)
        
        val tvFinalScore = findViewById<TextView>(R.id.tvFinalScore)
        val tvPersonalisedFeedback = findViewById<TextView>(R.id.tvPersonalisedFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        
        tvFinalScore.text = "Your Score: $Score / $total"
        
        tvPersonalisedFeedback.text = if (score >= 3) {
            "Master Hacker! You easily spot real shortcuts from viral myths."
        } else {
            "Stay Safe Online! Review the facts to avoid risky internet urban myths."
        }
        
        btnReview.setOnClickListener {
            Log.i(TAG, "Review button clicked. Finishing session.")
            finish()
        }
        
    }
}
