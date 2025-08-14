package com.example.linuxquiz.Quiz.presentation

import androidx.lifecycle.ViewModel
import com.example.linuxquiz.HomeScreen.Topic
import com.example.linuxquiz.Quiz.data.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel : ViewModel() {
    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> get() = _questions

    fun loadCategory(categoryKey: Int) {
        _questions.value = Category.questions[categoryKey] ?: emptyList()
    }




    companion object Category {
        val questions: Map<Int, List<Question>> = mapOf(
            1 to listOf(
                Question(
                    id = 1,
                    text = "What is the command to list all files in Linux?",
                    options = listOf("ls", "dir", "list", "show"),
                    correctAnswerIndex = 0,
                    explanation = ""
                ),
                Question(
                    id = 2,
                    text = "What is the command to make a new directory in Linux?",
                    options = listOf("mkdir", "md", "create", "make"),
                    correctAnswerIndex = 0,
                    explanation = ""
                ),
                Question(
                    id = 3,
                    text = "What is the command to delete a file in Linux?",
                    options = listOf("rm", "del", "delete", "remove"),
                    correctAnswerIndex = 0,
                    explanation = ""
                )
            ),
            2 to listOf(
                Question(
                    id = 1,
                    text = "What is the command to navigate to the home directory in Linux?",
                    options = listOf("cd", "cd ~", "cd /home", "cd ~/"),
                    correctAnswerIndex = 3,
                    explanation = ""
                ),
                Question(
                    id = 2,
                    text = "What is the command to list all files including hidden files in Linux?",
                    options = listOf("ls", "ls -a", "ls -l", "ls -al"),
                    correctAnswerIndex = 1,
                    explanation = ""
                ),
                Question(
                    id = 3,
                    text = "What is the command to navigate to the root directory in Linux?",
                    options = listOf("cd", "cd /", "cd ~/", "cd ~"),
                    correctAnswerIndex = 1,
                    explanation = ""
                )
            ),
        )
    }
}