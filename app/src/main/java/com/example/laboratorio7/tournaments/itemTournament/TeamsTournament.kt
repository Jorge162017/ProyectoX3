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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.laboratorio7.R


@Composable
fun TeamsTournament(tournament:String){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
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
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.prueba),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                        // Texto en la parte superior de la tarjeta
                        Text(
                            text = "EQUIPO 1",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Partidos Jugados(PJ): 3",
                        )
                        Text(
                            text = "Partidos Ganados(PG): 2",
                            color = Color(56, 176, 0)
                        )
                        Text(
                            text = "Partidos Empatados(PE): 1",
                            color = Color(250, 163, 7)
                        )
                        Text(
                            text = "Partidos Perdidos(PP): 0",
                            color = Color(208, 0, 0)
                        )

                        // Espaciador vertical
                        Spacer(modifier = Modifier.height(16.dp))

                        // Botón debajo del texto
                        Button(
                            onClick = {
                                // Acción a realizar cuando se hace clic en el botón
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(text = "Ver Plantilla")
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.prueba2),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                        // Texto en la parte superior de la tarjeta
                        Text(
                            text = "EQUIPO 2",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Partidos Jugados(PJ): 3",
                        )
                        Text(
                            text = "Partidos Ganados(PG): 1",
                            color = Color(56, 176, 0)
                        )
                        Text(
                            text = "Partidos Empatados(PE): 1",
                            color = Color(250, 163, 7)
                        )
                        Text(
                            text = "Partidos Perdidos(PP): 1",
                            color = Color(208, 0, 0)
                        )

                        // Espaciador vertical
                        Spacer(modifier = Modifier.height(16.dp))

                        // Botón debajo del texto
                        Button(
                            onClick = {
                                // Acción a realizar cuando se hace clic en el botón
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(text = "Ver Plantilla")
                        }
                    }
                }
            }
        }
    }
}