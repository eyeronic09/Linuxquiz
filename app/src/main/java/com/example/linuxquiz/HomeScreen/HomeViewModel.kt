// Update Topic.kt
package com.example.linuxquiz.HomeScreen

import androidx.lifecycle.ViewModel
import com.example.linuxquiz.Question.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Update HomeViewModel.kt
class HomeViewModel : ViewModel() {
    private val _topics = MutableStateFlow<List<Topic>>(emptyList())
    val topics: StateFlow<List<Topic>> = _topics.asStateFlow()

    init {
        loadTopics()
    }

     fun loadTopics() {
        val basicCommandsQuestions = listOf(
            Question(
                id = 1,
                text = "Which command is used to list directory contents?",
                options = listOf("ls", "dir", "list", "show"),
                correctAnswerIndex = 0,
                explanation = "The 'ls' command is used to list directory contents in Linux."
            ),
            Question(
                id = 2,
                text = "Which command is used to change directories?",
                options = listOf("cd", "chdir", "changedir", "move"),
                correctAnswerIndex = 0,
                explanation = "The 'cd' command is used to change the current directory."
            )
        )

        val fileSystemQuestions = listOf(
            Question(
                id = 3,
                text = "Which directory is the root of the filesystem?",
                options = listOf("/", "/root", "/home", "/var"),
                correctAnswerIndex = 0,
                explanation = "The root directory is represented by a single forward slash '/'."
            )
        )

        val topicsList = listOf(
            Topic(
                id = 1,
                topic = "Basic Commands",
                description = "Learn essential Linux commands",
                questionsCount = basicCommandsQuestions.size,
                questions = basicCommandsQuestions
            ),
            Topic(
                id = 2,
                topic = "File System",
                description = "Understand Linux file system structure",
                questionsCount = fileSystemQuestions.size,
                questions = fileSystemQuestions
            )
        )

        _topics.value = topicsList
    }

    // Add a function to get questions for a specific topic
    fun getQuestionsForTopic(topicId: Int): List<Question> {
        return topics.value.find { it.id == topicId }?.questions ?: emptyList()
    }
}