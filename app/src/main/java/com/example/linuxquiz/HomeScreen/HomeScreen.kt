package com.example.linuxquiz.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.linuxquiz.HomeScreen.component.Tab
import com.example.linuxquiz.HomeScreen.component.TopicCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel , onTopicClick  : (Int) -> Unit ) {
    val tabs = listOf(
        Tab(
            "category",
            selectedIcon = Icons.Default.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        Tab(
            title = "progress",
            selectedIcon = Icons.Default.Person,
            unselectedIcon = Icons.Outlined.Person
        )

    )
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, tab ->
                    NavigationBarItem(
                        selected = index == selectedTabIndex,
                        onClick = {selectedTabIndex = index},
                        icon = {
                            Icon(
                                imageVector = if (index == selectedTabIndex) {
                                    tab.selectedIcon
                                } else {
                                    tab.unselectedIcon
                                },
                                contentDescription = null
                            )
                        }
                    )
                }

            }
        }
    ) {  innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            val topics by viewModel.topics.collectAsStateWithLifecycle()
            LazyColumn() {
                items(items = topics , key = { it -> it.id }) { topics ->
                    TopicCard(
                        topic = topics ,
                        onClick = { onTopicClick(topics.id) },
                    )
                }
            }

        }

    }

}
