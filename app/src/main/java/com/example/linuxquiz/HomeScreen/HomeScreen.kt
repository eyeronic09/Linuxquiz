package com.example.linuxquiz.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.linuxquiz.HomeScreen.component.TopicCard

@Composable
fun HomeScreen(viewModel: HomeViewModel , onTopicClick  : (Int) -> Unit ) {
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        val topics by viewModel.topics.collectAsState()
        LazyColumn() {
            items(topics , key = { it -> it.id }) { topics ->
                TopicCard(
                    topic = topics ,
                    onClick = { onTopicClick(topics.id) },
                )
            }
        }
    }
}
