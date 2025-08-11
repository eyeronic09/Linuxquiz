package com.example.linuxquiz.Question

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun QuizScreen(question: List<Question>) {

    var selectedAnswer by remember { mutableIntStateOf(-1) }
    var currentQuestionIndex by remember { mutableIntStateOf(0) }

    val currentQuestion = question.getOrNull(currentQuestionIndex)
    var score by remember { mutableIntStateOf(0) }

    var question by remember { mutableStateOf(question) }

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Text(
            text = currentQuestion?.text ?: "Loading",
            style = MaterialTheme.typography.titleLarge
        )
        Text("$score / ${question.size}")
        currentQuestion?.options?.forEachIndexed { index, options ->
            val isSelected  = index == selectedAnswer
            val isCorrect  = index == currentQuestion.correctAnswerIndex

            OutlinedButton(
                onClick = {
                    Log.d("QuizScreen", "Clicked: $index, correct: $isCorrect, selected: $isSelected")
                    if (index == currentQuestion.correctAnswerIndex) {
                        score++
                        currentQuestionIndex++
                        Log.d("QuizScreen", "Correct!")
                    } else {
                        Log.d("QuizScreen", "Incorrect")
                    }

                    selectedAnswer = -1
                }
            ) {

                Text(options)
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun QuizScreenPreview() {
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
    QuizScreen(sampleQuestions)
}