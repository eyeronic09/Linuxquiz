package com.example.linuxquiz.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        val topic by viewModel.topics.collectAsState()
//        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(() { topic ->
//                Text()
//            }
//        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun prev() {
    HomeScreen(HomeViewModel())
}