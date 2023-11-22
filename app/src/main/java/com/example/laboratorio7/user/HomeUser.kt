package com.example.laboratorio7.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.laboratorio7.R
import com.example.laboratorio7.models.Tournament
import com.example.laboratorio7.user.HomeModel.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage


val listTournaments = mutableListOf<Tournament>()

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)

@Composable
fun HomeUser(navController: NavHostController, viewModel: HomeViewModel = viewModel()) {
    val context = LocalContext.current
    var sharedPreferencesManager: SharedPreferencesManager = SharedPreferencesManager(context)

    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    if (viewModel.homeUiState.leagues.isEmpty()) {

        viewModel.getLeagues(sharedPreferencesManager.getToken())
    }




    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth(),
            color = Color(33, 37, 41)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_account_box_24),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp),
                        tint = Color(47, 47, 49)
                    )
                    TextField(
                        value = searchText, // Utiliza textValue como el valor del TextField
                        onValueChange = { newText ->
                            if (newText.text.length <= 10) {
                                searchText = newText // Actualiza textValue en lugar de text
                            }
                        },
                        label = { Text("Torneos", color = Color(120, 120, 122)) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier,
                        shape = RoundedCornerShape(2.dp),
                        textStyle = TextStyle(color = Color(120, 120, 122)),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color(120, 120, 122),
                            unfocusedIndicatorColor = Color(120, 120, 122),
                            containerColor = Color(47, 47, 49)
                        ),

                        )

                }
            }


        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Button(
                onClick = {

                },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color.Black
                )
            ){
                Text(text = "Football",
                    color = Color.White)
            }

        }
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Football",
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Torneos",
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(50.dp))
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
        ) {
            items(viewModel.homeUiState.leagues) { league ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .clickable(onClick = {

                        })
                        .padding(start = 16.dp, top = 12.dp, bottom = 12.dp)
                ) {
                    AsyncImage(
                            model = "https://tournament.workcodeinc.com:3800/torneo/getImageLeague/"+league.logo,
                            contentDescription = null,
                            modifier = Modifier.width(150.dp).padding(0.dp,0.dp,10.dp,0.dp),
                        )

                    Text(
                        text = league.name,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }

                Divider(color = Color(47, 47, 49), thickness = 0.2.dp)


            }
        }

    }

}




@Composable
fun Sidebar(){
    Column(
        modifier = Modifier

    ) {
        for (tournament in listTournaments) {
            SidebarItem(idImage = tournament.logo, text = tournament.name) {
                // Handle Home item click
            }
        }


    }
}


@Composable
fun SidebarItem(idImage:Int, text: String, onItemClick: () -> Unit) {

    val image = painterResource(id = idImage)

    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .clickable(onClick = onItemClick)
            .padding(start = 16.dp, top = 12.dp, bottom = 12.dp)

    ) {
        Box(
        ){
            Image(
                painter = image,
                contentDescription=text,
                modifier = Modifier
                    .graphicsLayer(alpha = 1f) // Adjust this alpha to control the image opacity
                    .drawWithContent {
                        drawContent()


                    }

            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }

    Divider(color = Color(47, 47, 49), thickness = 0.2.dp)
}
