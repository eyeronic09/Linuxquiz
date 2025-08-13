package com.example.linuxquiz.Topic2QuestionQuiz

import androidx.lifecycle.ViewModel
import com.example.linuxquiz.Topic1QuestionQuiz.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModel1() : ViewModel() {
    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions.asStateFlow()

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        val sampleQuestions = listOf(
            Question(
                id = 1,
                text = "Which command lists the contents of the current directory?",
                options = listOf("ls", "dir", "list", "show"),
                correctAnswerIndex = 0,
                explanation = "The 'ls' command is used to list the contents of the current directory."
            ),
            Question(
                id = 2,
                text = "What is the command to change directories?",
                options = listOf("cd", "chdir", "changedir", "move"),
                correctAnswerIndex = 0,
                explanation = "The 'cd' command is used to change directories."
            ),
        )
        _questions.value = sampleQuestions
    }

}