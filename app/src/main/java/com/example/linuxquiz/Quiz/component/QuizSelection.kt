package com.example.linuxquiz.Quiz.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.linuxquiz.Quiz.data.room.Question


@Composable
fun QuizLayOutScreen(
    questions: List<Question>,
    onQuizComplete: (score: Int, total: Int) -> Unit,
    onAnswerSelected  : (answerIndex : Int) -> Unit

) {

    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableIntStateOf(-1) }
    var score by remember { mutableIntStateOf(0) }
    var showResult by remember { mutableStateOf(false) }

    val currentQuestion = questions.getOrNull(currentQuestionIndex)

    if (currentQuestion == null || showResult) {
        ResultScreen(
            score = score,
            totalQuestions = questions.size,
            onRestart = {
                currentQuestionIndex = 0
                score = 0
                selectedAnswer = -1
                showResult = false
            }
        )
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Progress indicator
        LinearProgressIndicator(
            progress = { (currentQuestionIndex + 1).toFloat() / questions.size },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Question
        Text(
            text = currentQuestion.text,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Options
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            currentQuestion.options.forEachIndexed { index, option ->
                val isSelected = selectedAnswer == index
                val isCorrect = index == currentQuestion.correctAnswerIndex

                OutlinedButton(
                    onClick = {
                        selectedAnswer = index
                        // Notify parent about the selected answer
                        onAnswerSelected(index)
                        // Update score if the answer is correct
                        if (isCorrect) {
                            score++
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = when {
                            isSelected && isCorrect -> Color.Green.copy(alpha = 0.2f)
                            isSelected -> Color.Red.copy(alpha = 0.2f)
                            else -> MaterialTheme.colorScheme.surface
                        },
                        contentColor = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    Text(option)
                }
            }
        }

        // Next button
        Button(
            onClick = {
                if (selectedAnswer != -1) {
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                        selectedAnswer = -1
                    } else {
                        onQuizComplete(score, questions.size)
                        showResult = true
                    }
                }
            },
            enabled = selectedAnswer != -1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(if (currentQuestionIndex < questions.size - 1) "Next" else "Finish")
        }
    }
}

@Composable
fun ResultScreen(
    score: Int,
    totalQuestions: Int,
    onRestart: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Quiz Complete!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Your score: $score out of $totalQuestions",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(onClick = onRestart) {
            Text("Restart Quiz")
        }
    }
}