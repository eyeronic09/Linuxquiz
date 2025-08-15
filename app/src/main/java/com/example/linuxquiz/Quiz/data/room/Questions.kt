package com.example.linuxquiz.Quiz.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity(tableName = "Quiz_table")
data class Question(
    @PrimaryKey()
    val id: Int,
    val text: String,
    @TypeConverters(Converters::class)
    val options: List<String>,
    val isCorrect : Boolean = false,
    val correctAnswerIndex: Int, // index of the correct answer in options list
    val explanation: String = "" // Optional explanation for the answer
)

