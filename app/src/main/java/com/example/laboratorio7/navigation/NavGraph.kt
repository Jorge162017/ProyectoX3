package com.example.laboratorio7.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio7.auth.Login
import com.example.laboratorio7.auth.SignUp
import com.example.laboratorio7.user.HomeUser

@Composable
fun NavigationGraph(navController: NavHostController = rememberNavController(), defaultDestination:String) {
    NavHost(navController, startDestination = defaultDestination) {
        composable("login") {
            Login(navController)
        }
        composable("signup"){
            SignUp(navController)
        }
        composable("homeuser"){
            HomeUser(navController)
        }
    }
}
