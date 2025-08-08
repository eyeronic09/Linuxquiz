package com.example.linuxquiz.HomeScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel(){
    private val _topics = MutableStateFlow<List<Topic>>(emptyList())
    val topics: StateFlow<List<Topic>> = _topics.asStateFlow()

    init {
        loadTopics()
    }

    private fun loadTopics() {
        val topics = listOf(
            Topic(1,"Topic 1" , "Description 1" , 10),
            Topic(2,"Topic 2" , "Description 2" , 20),
        )
        _topics.value = topics
    }


}