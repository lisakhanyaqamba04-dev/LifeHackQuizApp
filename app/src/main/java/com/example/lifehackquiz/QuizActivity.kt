package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private val TAG = "QuizActivity"

    // List of questions (Mix of Hacks and Myths)
    private val questions = listOf(
        Question("Putting a wet phone in rice will fix it.", false, "Myth. Rice can introduce dust and starch into the ports. It's better to power it off and let it air dry."),
        Question("You can cool a drink faster by wrapping it in a wet paper towel and putting it in the freezer.", true, "Hack. Evaporating water pulls heat away from the bottle much faster."),
        Question("Placing a wooden spoon across a boiling pot stops it from boiling over.", true, "Hack. The wooden spoon pops the surface tension bubbles."),
        Question("If you get a bee sting, put vinegar on it to neutralize the venom.", false, "Myth. Bee venom is acidic; vinegar is also acidic. Use baking soda (base) instead.")
    )

    private var currentQuestionIndex = 0
    private var score = 0
    private lateinit var tvQuestion: TextView
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        Log.d(TAG, "Quiz screen created")

        tvQuestion = findViewById(R.id.tvQuestion)
        btnHack = findViewById(R.id.btnHack)
        btnMyth = findViewById(R.id.btnMyth)
        btnNext = findViewById(R.id.btnNext)

        // Initially hide Next button until an answer is selected
        btnNext.isEnabled = false

        loadQuestion()

        btnHack.setOnClickListener {
            checkAnswer(userChoice = true)
        }

        btnMyth.setOnClickListener {
            checkAnswer(userChoice = false)
        }

        btnNext.setOnClickListener {
            Log.d(TAG, "Next button clicked")
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                navigateToScore()
            }
        }
    }

    private fun loadQuestion() {
        val currentQuestion = questions[currentQuestionIndex]
        tvQuestion.text = currentQuestion.statement

        // Reset buttons for new question
        btnHack.isEnabled = true
        btnMyth.isEnabled = true
        btnNext.isEnabled = false
        Log.d(TAG, "Loaded question: ${currentQuestion.statement}")
    }

    private fun checkAnswer(userChoice: Boolean) {
        val currentQuestion = questions[currentQuestionIndex]

        // Disable answer buttons after selection
        btnHack.isEnabled = false
        btnMyth.isEnabled = false
        btnNext.isEnabled = true

        if (userChoice == currentQuestion.isHack) {
            score++
            Toast.makeText(this, "Correct! That's a real time-saver!", Toast.LENGTH_SHORT).show()
            Log.i(TAG, "User answered correctly. Current Score: $score")
        } else {
            Toast.makeText(this, "Wrong! That's just an urban myth.", Toast.LENGTH_SHORT).show()
            Log.i(TAG, "User answered incorrectly.")
        }
    }

    private fun navigateToScore() {
        Log.i(TAG, "Quiz finished. Final score: $score")
        val intent = Intent(this, ScoreActivity::class.java)
        // Pass the score and total questions to the next activity
        intent.putExtra("FINAL_SCORE", score)
        intent.putExtra("TOTAL_QUESTIONS", questions.size)
        startActivity(intent)
        finish() // Close quiz activity so back button doesn't return to it
    }
}
