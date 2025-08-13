// Update Topic.kt
package com.example.linuxquiz.HomeScreen

import androidx.lifecycle.ViewModel
import com.example.linuxquiz.Topic1QuestionQuiz.Question
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
        val topicsList = listOf(
            Topic(id = 1, topic = "Command Line", description = "This topic is all about command line interface", questionsCount = 10, questions = emptyList()),
            Topic(id = 2, topic = "File System", description = "This topic is all about file systems in Linux", questionsCount = 10, questions = emptyList()),
            Topic(id = 3, topic = "Users and Groups", description = "This topic is all about users and groups in Linux", questionsCount = 10, questions = emptyList()),
            Topic(id = 4, topic = "Security", description = "This topic is all about security in Linux", questionsCount = 10, questions = emptyList()),
            Topic(id = 5, topic = "Networking", description = "This topic is all about networking in Linux", questionsCount = 10, questions = emptyList())
        )
        _topics.value = topicsList
    }

}

