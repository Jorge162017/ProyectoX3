package com.example.laboratorio7.tournaments.NavBottom


import com.example.laboratorio7.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Match : BottomNavItem("Match", R.drawable.match_24,"match")
    object Teams: BottomNavItem("Teams",R.drawable.team_24,"teams")
    object Table: BottomNavItem("Table",R.drawable.table_24,"table")
}