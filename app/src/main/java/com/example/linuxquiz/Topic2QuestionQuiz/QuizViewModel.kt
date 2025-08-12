package com.example.linuxquiz.Topic2QuestionQuiz

import androidx.lifecycle.ViewModel
import com.example.linuxquiz.Topic1QuestionQuiz.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel() : ViewModel() {
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
            Question(
                id = 3,
                text = "What is the command to copy a file?",
                options = listOf("copy", "cp", "duplicate", "clone"),
                correctAnswerIndex = 1,
                explanation = "The 'cp' command is used to copy a file."
            ),
            Question(
                id = 4,
                text = "What is the command to delete a directory?",
                options = listOf("trashIcon", "del", "rm", "rmdir"),
                correctAnswerIndex = 2,
                explanation = "The 'rm' command is used to delete a directory."
            ),
            Question(
                id = 5,
                text = "What is the command to create a directory?",
                options = listOf("create", "mk", "dir", "mkdir"),
                correctAnswerIndex = 3,
                explanation = "The 'mkdir' command is used to create a directory."
            ),
            Question(
                id = 6,
                text = "What is the command to print the current directory?",
                options = listOf("pwd", "print", "current", "directory"),
                correctAnswerIndex = 0,
                explanation = "The 'pwd' command is used to print the current directory."
            ),
            Question(
                id = 7,
                text = "What is the command to delete a file?",
                options = listOf("trashIcon", "del", "rm", "delete"),
                correctAnswerIndex = 2,
                explanation = "The 'rm' command is used to delete a file."
            ),
            Question(
                id = 8,
                text = "What is the command to move a file?",
                options = listOf("mv", "move", "rename", "copy"),
                correctAnswerIndex = 0,
                explanation = "The 'mv' command is used to move a file."
            ),
            Question(
                id = 9,
                text = "What is the command to rename a file?",
                options = listOf("mv", "move", "rename", "copy"),
                correctAnswerIndex = 0,
                explanation = "The 'mv' command is used to rename a file."
            ),
            Question(
                id = 10,
                text = "What is the command to create a new file?",
                options = listOf("touch", "create", "mk", "new"),
                correctAnswerIndex = 0,
                explanation = "The 'touch' command is used to create a new file."
            ) ,
            Question(
                    id = 11,
            text = "In the Linux file system, what is the top-most directory called?",
            options = listOf("home", "root", "system", "bin"),
            correctAnswerIndex = 1,
            explanation = "The top-most directory in the Linux file system is called the 'root' directory, denoted by a single '/'."
        ),
        Question(
            id = 12,
            text = "Which command is used to display the type of a file?",
            options = listOf("type", "file", "stat", "info"),
            correctAnswerIndex = 1,
            explanation = "The 'file' command is used to determine and display the type of a file."
        ),
        Question(
            id = 13,
            text = "What is the command to display the size of a file or directory?",
            options = listOf("size", "du", "stat", "info"),
            correctAnswerIndex = 1,
            explanation = "The 'du' command is used to display the size of a file or directory."
        ),
        Question(
            id = 14,
            text = "What is the command to display the permissions of a file or directory?",
            options = listOf("permissions", "chmod", "stat", "info"),
            correctAnswerIndex = 1,
            explanation = "The 'chmod' command is used to display the permissions of a file or directory."
        ),
        )
        _questions.value = sampleQuestions
    }

}