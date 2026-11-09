package com.example.lifehackquiz

data class Flashcard(
  val statement: String,
  val isHack: Boolean, // true for Hack (True), false for Myth (False)
  val explanation: String
)
