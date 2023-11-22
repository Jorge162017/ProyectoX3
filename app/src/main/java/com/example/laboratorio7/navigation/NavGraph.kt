package com.example.laboratorio7.navigation



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.laboratorio7.auth.Login
import com.example.laboratorio7.auth.SignUp
import com.example.laboratorio7.tournaments.AddTournament
import com.example.laboratorio7.tournaments.ViewTournament
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
        
        composable("addtournament"){
            AddTournament(navController = navController)
        }

        composable(
            route = "viewTournament/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            id?.let {
                ViewTournament(navController = navController, tournament= it)
            }
        }
    }
}
