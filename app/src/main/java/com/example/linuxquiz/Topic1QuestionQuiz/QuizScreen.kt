package com.example.linuxquiz.Topic1QuestionQuiz

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun QuizScreen(viewModel: QuizViewModel) {
    val question by viewModel.questions.collectAsState()
    var selectedAnswer by remember { mutableIntStateOf(-1) }
    var currentQuestionIndex by remember { mutableIntStateOf(0) }

    val currentQuestion = question.getOrNull(currentQuestionIndex)

    var score by remember { mutableIntStateOf(0) }

    if (currentQuestion != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(currentQuestion.text)
            currentQuestion.options.forEachIndexed { index, options ->
                val isSelected = index == selectedAnswer
                val isCorrect = index == currentQuestion.correctAnswerIndex
                Log.d("QuizScreen", "Clicked: $index, correct: $isCorrect, selected: $isSelected")
                OutlinedButton(onClick = {
                    if (isSelected != isCorrect) {
                        currentQuestionIndex++
                        selectedAnswer = -1
                    }
                }) {
                    Text(options)
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showSystemUi = true)
@Composable
fun QuizScreenPreview() {
    val viewModel = QuizViewModel()
    QuizScreen(viewModel = viewModel)
}