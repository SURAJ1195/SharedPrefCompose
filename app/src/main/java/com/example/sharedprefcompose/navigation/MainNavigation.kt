package com.example.sharedprefcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sharedprefcompose.screen.MainScreen
import com.example.sharedprefcompose.screen.RegisterScreen
import com.example.sharedprefcompose.screen.SecondScreen

@Composable
fun MainNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =NavigationScreens.MainScreen.name  ){
        composable(NavigationScreens.MainScreen.name){
            MainScreen(navController)
        }
        composable(NavigationScreens.SecondScreen.name){
            SecondScreen(navController)
        }
        composable(NavigationScreens.RegistrationScreen.name){
            RegisterScreen(navController)
        }
    }
}