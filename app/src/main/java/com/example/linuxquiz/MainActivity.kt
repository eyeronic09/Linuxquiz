package com.example.linuxquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.linuxquiz.HomeScreen.HomeScreen
import com.example.linuxquiz.HomeScreen.HomeViewModel
import com.example.linuxquiz.Navigation.Screen
import com.example.linuxquiz.Quiz.presentation.Quiz1Screen
import com.example.linuxquiz.Quiz.presentation.QuizViewModel
import com.example.linuxquiz.ui.theme.LinuxquizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LinuxquizTheme {
                AppNav()
            }
        }
    }
}

@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(
                viewModel = viewModel,
                onTopicClick = { topicId ->
                    navController.navigate(Screen.Quiz.createRoute(topicId))
                }
            )
        }
        composable(
            Screen.Quiz.route,
            arguments = listOf(navArgument("topicId") { type = NavType.IntType })
        ) { backStack ->
            val topicId = backStack.arguments?.getInt("topicId") ?: 0
            val viewModel: QuizViewModel = viewModel()
            Quiz1Screen(viewModel = viewModel, topicId)
        }
    }
}

@Preview
@Composable
private fun prevs() {
    AppNav()
}