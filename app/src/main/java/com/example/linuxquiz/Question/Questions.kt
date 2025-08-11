package com.example.linuxquiz.Question

data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int, // index of the correct answer in options list
    val explanation: String = "" // Optional explanation for the answer
)