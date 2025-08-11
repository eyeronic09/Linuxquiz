package com.example.linuxquiz.HomeScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.linuxquiz.HomeScreen.Topic


@Composable
fun TopicCard(topic: Topic , onClick : () -> Unit = {}) {
    OutlinedCard(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clickable{ onClick() }) {
        Column(modifier = Modifier.padding(16.dp ).fillMaxWidth()) {
            Text(
                text = topic.topic,
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = topic.description ,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(text = topic.questionsCount.toString() + " Questions", modifier = Modifier.align(Alignment.End))
        }
    }
}
@Preview
@Composable
fun TopicCardPreview() {
    TopicCard(Topic(
        id = 1, topic = "topic", description = "description", questionsCount = 10,
        questions = emptyList()
    ))
}