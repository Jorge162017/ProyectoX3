package com.example.laboratorio7.tournaments.itemTournament

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TeamStats(
    val posicion: Int,
    val equipo: String,
    val PJ: Int,
    val PG: Int,
    val PE: Int,
    val PP: Int,
    val GC: Int,
    val GF: Int,
    val GD: Int,
    val PTS: Int
)

@Composable
fun TableTournament(tournament:String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 50.dp)
        ) {
            Surface(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth(),
                color = Color(33, 37, 41)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "NOMBRE TORNEO - TABLA",
                        modifier = Modifier,
                        fontSize = 40.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            lineHeight = 35.sp
                        )
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                // Header Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(5.dp)
                ) {
                    Text(text = "#", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "Equipo", modifier = Modifier.weight(2f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "PJ", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "G", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "E", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "P", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "GC", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "GF", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "GD", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "PTS", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold, color = Color(30, 136, 229))
                }

                val teamsData = generateDummyData()
                LazyColumn {
                    items(teamsData) { teamStats ->
                        DataRow(teamStats)
                    }
                }
            }
        }
    }
}
@Composable
fun DataRow(teamStats: TeamStats) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(5.dp)
            //.border(width = 1.dp, color = Color.Gray)
    ) {
        Text(text = "${teamStats.posicion}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.equipo}", modifier = Modifier.weight(2f),fontSize = 12.sp)
        Text(text = "${teamStats.PJ}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.PG}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.PE}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.PP}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.GC}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.GF}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.GD}", modifier = Modifier.weight(1f),fontSize = 12.sp)
        Text(text = "${teamStats.PTS}", modifier = Modifier.weight(1f),fontSize = 12.sp, color = Color(30, 136, 229))
    }
}
fun generateDummyData(): List<TeamStats> {
    return List(10) { index ->
        TeamStats(
            index * 1,
            "TEAM",
            index * 2,
            index * 2,
            index + 1,
            index + 3,
            index * 4,
            index * 2,
            index * 5,
            index * 5
        )
    }
}