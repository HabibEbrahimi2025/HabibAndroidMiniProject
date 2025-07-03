package com.example.mybusschedual

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybusschedual.navigationData.NavRouteData
import com.example.mybusschedual.ui.item.AddingScreen
import com.example.mybusschedual.ui.item.DetailScreen
import com.example.mybusschedual.ui.item.MainScreen

@Composable
fun SchedularApp(){
    val navController= rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRouteData.MainPage.route
    ) {
        composable(
            NavRouteData.MainPage.route
        ) {
            MainScreen(
                navController = navController
            )
        }
        composable(
            NavRouteData.AddingPage.route
        ) {
            AddingScreen(
                navController = navController
            )
        }

        composable (
            NavRouteData.DetailePage.route
        ){
            DetailScreen(
                navControler = navController
            )
        }
    }
}