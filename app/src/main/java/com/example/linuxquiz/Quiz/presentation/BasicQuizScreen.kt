package com.example.linuxquiz.Quiz.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.linuxquiz.Quiz.presentation.QuizViewModel
import com.example.linuxquiz.Quiz.component.QuizLayOutScreen

@Composable
fun Quiz1Screen(viewModel: QuizViewModel  , category: Int) {
    val questions by viewModel.questions.collectAsStateWithLifecycle()
    viewModel.loadCategory(category)
    if (questions.isNotEmpty()) {
        QuizLayOutScreen (
            questions = questions,
            onQuizComplete = {score, total ->
                // TODO : Add room updata
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
    Quiz1Screen(viewModel = viewModel , 2)
}