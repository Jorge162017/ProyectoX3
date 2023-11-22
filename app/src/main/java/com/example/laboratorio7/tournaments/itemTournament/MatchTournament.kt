package com.example.laboratorio7.tournaments.itemTournament

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import com.example.laboratorio7.tournaments.itemTournament.MatchModel.MatchViewModel
import com.example.laboratorio7.user.HomeModel.HomeViewModel

@Composable

fun MatchTournament(tournament:String, viewModel: MatchViewModel = viewModel()){
    val context = LocalContext.current
    var sharedPreferencesManager: SharedPreferencesManager = SharedPreferencesManager(context)

    if (viewModel.matchUiState.session.isEmpty()) {

        viewModel.getSessions(sharedPreferencesManager.getToken(), tournament)
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
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),

                color = Color(33, 37, 41),
            ) {
                Column(

                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "NOMBRE TORNEO - PARTIDOS",
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

            Column (
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
            {


                viewModel.matchUiState.session.forEach { session ->
                    Column {
                        Text(
                            text = session.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = Color.White,
                        )
                    }

                    var id = 0
                    session.matchs.forEach { match ->
                        id = id + 1;
                        Column {

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
                                    // Texto en la parte superior de la tarjeta
                                    Text(
                                        text = "PARTIDO ${id}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = "Resultado ${match.goalsFirst} vs ${match.goalsSecond}",
                                    )
                                    Text(
                                        text = "Equipo ${match.playersOne[0].name}",
                                    )
                                    Text(
                                        text = "contra",
                                    )
                                    Text(
                                        text = "equipo ${match.playersSecond[0].name}",
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
                                        Text(text = "Cambiar Resultado", color = Color.White)
                                    }
                                }
                            }
                        }

                    }

                }

            }
        }
    }

}