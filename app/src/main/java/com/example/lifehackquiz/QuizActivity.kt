package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppActivity()

	private val TAG = "QuizActivityDebug"
	
	private val flashcards = ListOf(
    Flashcard("Putting a wet paper towel around a beverage bottle cools it down faster in the freezer." true, "True! Evaporative cooling accelerates heat loss.") ,"
    Flashcard("Putting your phone in rice will instantly fix all liquid damage safely.", false, "False! Rice dust can clog ports, and silica gel or proper drying works much better."),
    Flashcard("Microwaving a sponge for 1-2 minutes can sanitize it.", true, "True! High moisture microwave heat kills most bacteria safely if the sponge is wet."),
    Flashcard("Opening your windows fully during extreme heat keeps the house cooler than closing blinds.", false, "False! Blocking direct sunlight keeps ambient heat out during peak sunshine hours.")
)
    
private var currentIndex = 0
private var score = 0

private lateinit var tvQuestion: TextView
private lateinit var tvFeedback: TextView
private lateinit var btnHack: Button
private lateinit var btnMyth: Button
private lateinit var btnNext: Button

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quiz)
    
    Log.d(TAG, "QuizActivity launched. Total questions: ${flashcards.size}")
    
    tvQuestion = findViewById(R.id.tvQuestion)
    tvFeedback = findViewById(R.id.tvFeedback)
    btnHack = findViewBtId(R.id.btnHack)
    btnMyth = findViewById(R.id.btnMyth)
    btnNext = findViewById(R.id.btnNext)
    
    loadQuestion()
    swer
    btnHack.setOnClickListener { checkAnswer(true)}
    btnMyth.setOnClickListener { checkAnswer(false)}
    
    btnNext.setOnClickListener {
        currentIndex++
        if (currentIndex++ < flashcards.size) {
            loadQuestion()
        } else {
            Log.i(TAG, "Quiz finished. Navigating to score Screen with score: $score")
            val intent = Intent(this, ScoreActivity::class.java).apply {
                putExtra("USER_SCORE", score)
                putExtra("TOTAL_QUESTIONS", flashcards.size)
            }
            startActivity(intent)
            finish()
        }
    }
}

private fun loadQuestion() {
    val currentCard = flashcards[currentIndex]
    tvQuestion.text = currentCard.statement
    tvFeedback.visibility = View.GONE
    btnNext.visibility = View.GONE
    
    btnHack.isEnabled = true
    btnMyth.isEnabled = true
    
}

private fun checkAnswer(userChoice: Boolean) {
    val currentCard = flashcards[currentIndex]
    val isCorrect = userChoice == currentCard.isHack
    
    if (isCorrect) {
        score++
        tvFeedback.text = "Correct! ${currentCard.explanation}"
    } else {
        tvFeedback.text = "Wrong! ${currentCard.explanation}"
    }
    
    tvFeedback.visibility = View.VISIBLE
    btnNext.visibility = View.VISIBLE
    btnHack.isEnabled = false
    btnMyth.isEnabled = false
    
}
    
    
    
    
        
        
    }
    
    
    
    
}


    
    
    
    
}
            
            
           
            
            
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}


