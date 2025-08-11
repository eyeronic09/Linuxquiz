package com.example.linuxquiz.Topic1QuestionQuiz

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel(): ViewModel() {
   private val _questions = MutableStateFlow<List<Question>>(emptyList())
   val questions: StateFlow<List<Question>> = _questions.asStateFlow()

   init {
       loadQuestions()
   }

     fun loadQuestions() {
            val sampleQuestions = listOf(
                Question(
                    id = 1,
                    text = "Which command lists directory contents?",
                    options = listOf("ls", "dir", "list", "show"),
                    correctAnswerIndex = 0,
                    explanation = "The 'ls' command is used to list directory contents in Linux."
                ),
                Question(
                    id = 2,
                    text = "Which command changes directories?",
                    options = listOf("cd", "chdir", "changedir", "move"),
                    correctAnswerIndex = 0,
                    explanation = "The 'cd' command changes the current directory."
                ),
                Question(
                    id = 3,
                    text = "What is the command to create a directory?",
                    options = listOf("create", "mk", "dir", "mkdir"),
                    correctAnswerIndex = 3,
                    explanation = "The 'mkdir' command is used to create a directory in Linux."
                ),
                Question(
                    id = 4,
                    text = "What is the command to delete a directory?",
                    options = listOf("trashIcon", "del", "rm", "rmdir"),
                    correctAnswerIndex = 2,
                    explanation = "The 'rm' command is used to delete a directory in Linux."
                )
            )
        _questions.value = sampleQuestions

    }
}