package com.example.laboratorio7.tournaments.itemTournament

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.laboratorio7.R
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import com.example.laboratorio7.tournaments.itemTournament.MatchModel.MatchViewModel
import com.example.laboratorio7.tournaments.itemTournament.TeamsModel.TeamViewModel


@Composable
fun TeamsTournament(tournament:String,  viewModel: TeamViewModel = viewModel()){

    val context = LocalContext.current
    var sharedPreferencesManager: SharedPreferencesManager = SharedPreferencesManager(context)

    if (viewModel.teamUiState.ls.teams.isEmpty()) {

        viewModel.getTeams(sharedPreferencesManager.getToken(), tournament)
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
                        text = "NOMBRE TORNEO - EQUIPOS",
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

                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                ) {
                    items(viewModel.teamUiState.ls.teams) { team ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(33, 37, 41))
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(
                                    model = "https://tournament.workcodeinc.com:3800/torneo/getImageLeague/"+team.logo,
                                    contentDescription = null,
                                    modifier = Modifier

                                        .padding(0.dp, 0.dp, 10.dp, 0.dp),
                                )
                                // Texto en la parte superior de la tarjeta
                                Text(
                                    text = team.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "Partidos Jugados(PJ): ${team.pj}",
                                )
                                Text(
                                    text = "Partidos Ganados(PG): ${team.pg}",
                                    color = Color(56, 176, 0)
                                )
                                Text(
                                    text = "Partidos Empatados(PE): ${team.pe}",
                                    color = Color(250, 163, 7)
                                )
                                Text(
                                    text = "Partidos Perdidos(PP): ${team.pp}",
                                    color = Color(208, 0, 0)
                                )

                                // Espaciador vertical
                                Spacer(modifier = Modifier.height(16.dp))

                                // Botón debajo del texto
                                IconButton(
                                    onClick = {

                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(15.dp),
                                    colors = IconButtonDefaults.iconButtonColors(
                                        containerColor = Color(3, 121, 255)
                                    ),
                                ) {
                                    // No hay icono en esta sección
                                    Text(text = "Ver Plantilla", color = Color.White)
                                }
                            }
                        }

                    }
                }


            }
        }
    }
}