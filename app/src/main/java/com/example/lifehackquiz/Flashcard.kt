package com.example.lifehackquiz
​
data class Flashcard(
    val statement: String,
    val isHack: Boolean, // true for Hack, false for Myth
    val explanation: String
)
​
