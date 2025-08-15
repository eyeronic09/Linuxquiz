package com.example.linuxquiz.Quiz.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.linuxquiz.Quiz.data.room.Question
import com.example.linuxquiz.Quiz.data.room.Repository.QuizDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuizViewModel(private val quizDao: QuizDao) : ViewModel() {
    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> get() = _questions

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> get() = _currentQuestionIndex


    fun loadCategory(categoryKey: Int) {
        val currentQuestion = Category.questions[categoryKey] ?: emptyList()
        Log.d("loadedCurrentQuestion","$currentQuestion" )

    }
    fun submitAnswer(selectedAnswerIndex : Int){
        val currentQuestion = _questions.value.getOrNull(_currentQuestionIndex.value) ?: return
        Log.d("DaoCurrentQuestion","$currentQuestion" )
        if ( currentQuestion.correctAnswerIndex == selectedAnswerIndex) {
            viewModelScope.launch {
                quizDao.update(currentQuestion.copy(isCorrect = true))
            }
        }

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

    class QuizViewModelFactory(
        private val quizDao: QuizDao
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return QuizViewModel(quizDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}