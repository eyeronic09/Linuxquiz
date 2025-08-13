package com.example.linuxquiz.Topic1QuestionQuiz

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.linuxquiz.Topic1QuestionQuiz.QuizLayout.QuizScreen
import com.example.linuxquiz.Topic1QuestionQuiz.QuizLayout.quizLayOutScreen

@Composable
fun Topic1QuizScreen(viewModel: QuizViewModel) {
    val questions by viewModel.questions.collectAsStateWithLifecycle()

    if (questions.isNotEmpty()) {
        quizLayOutScreen(
            questions = questions,
            onQuizComplete = {score, total ->

            }
        )
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showSystemUi = true)
@Composable
fun QuizScreenPreview() {
    val viewModel = QuizViewModel()
    Topic1QuizScreen(viewModel = viewModel)
}