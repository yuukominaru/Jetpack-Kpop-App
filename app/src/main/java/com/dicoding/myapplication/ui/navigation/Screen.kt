package com.dicoding.myapplication.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailGroup : Screen("home/{groupId}") {
        fun createRoute(groupId: Int) = "home/$groupId"
    }
}