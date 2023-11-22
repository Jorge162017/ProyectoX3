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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorio7.R
import com.example.laboratorio7.data.networking.Response.TeamResponse
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import com.example.laboratorio7.tournaments.itemTournament.TeamsModel.TeamViewModel

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
fun TableTournament(tournament:String, viewModel: TeamViewModel = viewModel()) {

    val context = LocalContext.current
    var sharedPreferencesManager: SharedPreferencesManager = SharedPreferencesManager(context)

    if (viewModel.positionUiState.teams.isEmpty()) {

        viewModel.listaPosition(sharedPreferencesManager.getToken(), tournament)
    }
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
                    Text(text = "#", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = stringResource(R.string.team), modifier = Modifier.weight(2f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "PJ", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "G", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "E", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "P", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "GC", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "GF", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "GD", modifier = Modifier.weight(1f),color= Color.White, fontSize = 12.sp,fontWeight = FontWeight.ExtraBold)
                    Text(text = "PTS", modifier = Modifier.weight(1f), fontSize = 12.sp,fontWeight = FontWeight.ExtraBold, color = Color(30, 136, 229))
                }

                var id = 0;
                LazyColumn {
                    items(viewModel.positionUiState.teams) { team ->
                        id =id++
                        DataRow(id, team)
                    }
                }
            }
        }
    }
}
@Composable
fun DataRow(id:Number, teamStats: TeamResponse) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(5.dp)
            //.border(width = 1.dp, color = Color.Gray)
    ) {
        Text(text = "${id}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.name}", modifier = Modifier.weight(2f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.pj}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.pg}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.pe}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.pp}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.gc}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.gf}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.gd}", modifier = Modifier.weight(1f), color= Color.White,fontSize = 12.sp)
        Text(text = "${teamStats.points}", modifier = Modifier.weight(1f), fontSize = 12.sp, color = Color(30, 136, 229))
    }
}


