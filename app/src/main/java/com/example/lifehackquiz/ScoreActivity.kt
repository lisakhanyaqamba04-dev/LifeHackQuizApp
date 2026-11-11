package com.example.lifehackquiz

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    private val TAG = "ScoreActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("FINAL_SCORE", 0)
        val total = intent.getIntExtra("TOTAL_QUESTIONS", 0)
        Log.d(TAG, "Score screen created. Score: $score/$total")

        val tvScore: TextView = findViewById(R.id.tvScore)
        val tvFeedback: TextView = findViewById(R.id.tvFeedback)
        val btnReview: Button = findViewById(R.id.btnReview)
        val btnRestart: Button = findViewById(R.id.btnRestart)

        tvScore.text = "Score: $score / $total"

        // Personalized feedback based on score
        if (score == total) {
            tvFeedback.text = "Master Hacker!"
        } else if (score >= total / 2) {
            tvFeedback.text = "Great job! You know your stuff."
        } else {
            tvFeedback.text = "Stay Safe Online! Keep practising."
        }

        btnReview.setOnClickListener {
            Log.d(TAG, "Review button clicked. Showing dialog.")
            showReviewDialog()
        }

        btnRestart.setOnClickListener {
            Log.d(TAG, "Restart button clicked.")
            // Go back to Welcome Screen
            val intent = android.content.Intent(this, WelcomeActivity::class.java)
            intent.flags = android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP or android.content.Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun showReviewDialog() {
        // In a real app, you'd pass the questions list here via Intent.
        // For simplicity in this assignment, we are re-instantiating the list.
        val questions = listOf(
            Question("Putting a wet phone in rice will fix it.", false, "Myth. Rice can introduce dust and starch into the ports."),
            Question("You can cool a drink faster by wrapping it in a wet paper towel...", true, "Hack. Evaporating water pulls heat away."),
            Question("Placing a wooden spoon across a boiling pot stops it from boiling over.", true, "Hack. The wooden spoon pops the surface tension bubbles."),
            Question("If you get a bee sting, put vinegar on it to neutralize the venom.", false, "Myth. Bee venom and vinegar are both acidic.")
        )

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Review: Hacks & Myths")

        val reviewText = StringBuilder()
        for ((index, q) in questions.withIndex()) {
            reviewText.append("${index + 1}. ${q.statement}\n")
            reviewText.append("Answer: ${if (q.isHack) "HACK" else "MYTH"}\n")
            reviewText.append("Why: ${q.explanation}\n\n")
        }

        builder.setMessage(reviewText.toString())
        builder.setPositiveButton("Close") { dialog, _ -> dialog.dismiss() }
        builder.show()
    }
}
