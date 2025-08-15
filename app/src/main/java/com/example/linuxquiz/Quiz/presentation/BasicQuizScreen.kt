package com.example.linuxquiz.Quiz.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.linuxquiz.Quiz.component.QuizLayOutScreen

@Composable
fun Quiz1Screen(
    viewModel: QuizViewModel,
    category: Int
) {
    // Load questions for the category when the screen is first shown
    LaunchedEffect(category) {
        viewModel.loadCategory(category)
    }
    
    // Collect the questions state
    val questions by viewModel.questions.collectAsStateWithLifecycle()
    val currentQuestionIndex by viewModel.currentQuestionIndex.collectAsStateWithLifecycle()
    
    Log.d("QuizScreen", "Questions loaded: ${questions.size}, Current index: ${currentQuestionIndex.toString()}")

    if (questions.isNotEmpty()) {
        QuizLayOutScreen(
            questions = questions,
            onQuizComplete = { score, total ->
                // Handle quiz completion
                Log.d("QuizScreen", "Quiz completed! Score: $score/$total")
            },
            onAnswerSelected =  {  answerIndex ->
                viewModel.submitAnswer(answerIndex)
                Log.d("QuizScreenDao", "Answer selected: $answerIndex")
            }
        )
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
