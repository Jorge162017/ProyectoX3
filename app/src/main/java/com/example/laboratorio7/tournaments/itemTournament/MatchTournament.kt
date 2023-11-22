package com.example.laboratorio7.tournaments.itemTournament

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun MatchTournament(tournament:String){
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
                        // Texto en la parte superior de la tarjeta
                        Text(
                            text = "PARTIDO 1",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Resultado 3 - 0",
                        )
                        Text(
                            text = "Equipo 1",
                        )
                        Text(
                            text = "contra",
                        )
                        Text(
                            text = "equipo 6",
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
                            Text(text = "Cambiar Resultado")
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
                        // Texto en la parte superior de la tarjeta
                        Text(
                            text = "PARTIDO 2",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Resultado 1 - 2",
                        )
                        Text(
                            text = "Equipo 3",
                        )
                        Text(
                            text = "contra",
                        )
                        Text(
                            text = "equipo 5",
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
                            Text(text = "Cambiar Resultado")
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
                        // Texto en la parte superior de la tarjeta
                        Text(
                            text = "PARTIDO 3",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Resultado 1 - 1",
                        )
                        Text(
                            text = "Equipo 2",
                        )
                        Text(
                            text = "contra",
                        )
                        Text(
                            text = "equipo 4",
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
                            Text(text = "Cambiar Resultado")
                        }
                    }
                }
            }
        }
    }

}