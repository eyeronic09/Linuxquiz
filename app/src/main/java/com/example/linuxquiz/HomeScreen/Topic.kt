package com.example.linuxquiz.HomeScreen

import com.example.linuxquiz.Quiz.data.room.Question

data class Topic(
    val id : Int,
    val topic: String ,
    val description: String,
    val questionsCount: Int  ,
    val questions: List<Question>)
