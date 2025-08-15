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
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.example.linuxquiz.HomeScreen.component.BottomNavigationBar
import com.example.linuxquiz.HomeScreen.component.Tab
import com.example.linuxquiz.HomeScreen.component.TopicCard
import com.example.linuxquiz.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel , onTopicClick  : (Int) -> Unit , navController: NavController  ) {
    val tabs = listOf(
        Tab(
            "category",
            selectedIcon = Icons.Default.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = Screen.Home.route
        ),
        Tab(
            title = "progress",
            selectedIcon = Icons.Default.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = Screen.Progress.route
        )
    )


    // Get the current route from the NavController. If the NavController is null
    // or there is no current back stack entry, default to the Home screen route.
    val currentRoute = navController.currentBackStackEntry?.destination?.route ?: Screen.Home.route


    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {

                BottomNavigationBar(
                    tabs = tabs,
                    currentRoute = currentRoute,
                    onTabSelected = { route ->
                        if (route != currentRoute) {
                            navController.navigate(route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )

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
