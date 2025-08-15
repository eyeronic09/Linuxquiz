package com.example.linuxquiz.Navigation

import com.example.linuxquiz.HomeScreen.Topic

sealed class Screen (val route : String){
    object Home : Screen("Home")

    object Progress : Screen("Progress")
    object Quiz : Screen("quiz/{topicId}"){
        fun createRoute(topicId: Int)  = "quiz/$topicId"
    }
}