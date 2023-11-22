
package com.example.laboratorio7.tournaments.NavBottom

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio7.R
import androidx.compose.ui.res.painterResource
import com.example.laboratorio7.tournaments.NavBottom.BottomNavItem
import com.example.laboratorio7.tournaments.itemTournament.MatchTournament
import com.example.laboratorio7.tournaments.itemTournament.TableTournament
import com.example.laboratorio7.tournaments.itemTournament.TeamsTournament
import com.example.laboratorio7.tournaments.itemTournament.addTeamTournament


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigation(tournament: String ) {
    val navController: NavHostController= rememberNavController()

    Scaffold(
        bottomBar = {
            val items = listOf(
                BottomNavItem.Match,
                BottomNavItem.Teams,
                BottomNavItem.Table,
            )
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.black),
                contentColor = Color.White
            ){
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = 9.sp
                            )
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.screen_route,
                        onClick = {
                            navController.navigate(item.screen_route) {

                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }

        }
    ){
        NavigationGraph(navController = navController, tournament)

    }

}

@Composable
fun NavigationGraph(navController: NavHostController, tournament:String) {
    NavHost(navController, startDestination = BottomNavItem.Match.screen_route) {
        composable(BottomNavItem.Match.screen_route) {
            MatchTournament(tournament)
        }
        composable(BottomNavItem.Teams.screen_route) {
            TeamsTournament(navController,tournament)
        }
        composable(BottomNavItem.Table.screen_route) {
            TableTournament(tournament)
        }

        composable("addTeam"){
            addTeamTournament(navController = navController, tournament = tournament)
        }

    }
}

