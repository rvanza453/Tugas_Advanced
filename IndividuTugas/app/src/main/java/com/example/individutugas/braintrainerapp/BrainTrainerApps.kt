package com.example.individutugas.braintrainerapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.individutugas.R

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var userAnswerEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var rematchButton: Button
    private lateinit var scoreTextView: TextView

    private var currentQuestion: Int = 1
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brain_trainer_apps)

        questionTextView = findViewById(R.id.questionTextView)
        userAnswerEditText = findViewById(R.id.userAnswerEditText)
        submitButton = findViewById(R.id.submitButton)
        rematchButton = findViewById(R.id.rematchButton)
        scoreTextView = findViewById(R.id.scoreTextView)

        updateQuestion()

        submitButton.setOnClickListener {
            checkAnswer()
            updateQuestion()
        }

        rematchButton.setOnClickListener {
            startRematch()
        }
    }

    private fun updateQuestion() {
        currentQuestion++
        if (currentQuestion > 5) {
            showScore()
        } else {
            questionTextView.text = "$currentQuestion + $currentQuestion = ?"
            userAnswerEditText.text.clear()
        }
    }

    private fun checkAnswer() {
        val userAnswer = userAnswerEditText.text.toString()
        val correctAnswer = currentQuestion + currentQuestion
        if (userAnswer == correctAnswer.toString()) {
            score++
        }
        updateScore()
    }

    private fun updateScore() {
        scoreTextView.text = "Score: $score"
    }

    private fun showScore() {
        questionTextView.text = "Game Over"
        userAnswerEditText.visibility = View.GONE
        submitButton.visibility = View.GONE
        rematchButton.visibility = View.VISIBLE
        scoreTextView.text = "Final Score: $score"
    }

    private fun startRematch() {
        currentQuestion = 1
        score = 0
        updateQuestion()
        userAnswerEditText.visibility = View.VISIBLE
        submitButton.visibility = View.VISIBLE
        rematchButton.visibility = View.GONE
        scoreTextView.text = "Score: 0"
    }
}
