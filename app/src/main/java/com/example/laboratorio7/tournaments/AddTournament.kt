package com.example.laboratorio7.tournaments

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.laboratorio7.R
import com.example.laboratorio7.auth.UserModel.UserViewModel
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import com.example.laboratorio7.tournaments.TournamentModel.TournamentViewModel
import com.example.laboratorio7.user.HomeModel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTournament(navController: NavHostController,  viewModel: TournamentViewModel = viewModel()) {
    val context = LocalContext.current
    var sharedPreferencesManager: SharedPreferencesManager = SharedPreferencesManager(context)
    var nameText by remember { mutableStateOf(TextFieldValue("")) }
    var seasonText by remember { mutableStateOf(TextFieldValue("")) }
    var textValue by remember { mutableStateOf(TextFieldValue("")) }
    val coroutineScope = CoroutineScope(Dispatchers.Main)

    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
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
                    text = "TORNEOS X3",
                    modifier = Modifier,
                    fontSize = 40.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "CREAR TORNEO",
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(50.dp))
        }

        //nombre
        Row {
            Icon(
                painter = painterResource(id = R.drawable.name_tournament),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = nameText,
                onValueChange = { newText ->
                        nameText = newText
                },
                label = { Text("Nombre", color = Color(120, 120, 122)) },
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
        Spacer(modifier = Modifier.height(30.dp))

        // season

        Row {
            Icon(
                painter = painterResource(id = R.drawable.season_tournament),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = seasonText,
                onValueChange = { newText ->
                        seasonText = newText
                },
                label = { Text("Temporada", color = Color(120, 120, 122)) },
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
        Spacer(modifier = Modifier.height(30.dp))

        //Descripcion
        Row {
            Icon(
                painter = painterResource(id = R.drawable.description_tournament),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = textValue, // Utiliza textValue como el valor del TextField
                onValueChange = { newText ->
                        textValue = newText // Actualiza textValue en lugar de text
                },
                label = { Text("Descripcion", color = Color(120, 120, 122)) },
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


        var bitmap = PhotoSelector()
        Spacer(modifier = Modifier.height(40.dp))
        Divider(
            color = Color(120, 120, 122),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(6.dp, 0.dp, 6.dp, 0.dp)// Altura del Divider
        )
        Spacer(modifier = Modifier.height(40.dp))

        IconButton(

            onClick = {

                coroutineScope.launch {
                    if (listOf(nameText.text, seasonText.text, textValue.text).all { it.isNotEmpty() }) {
                        // Perform the operation
                        viewModel.saveLeague(
                            sharedPreferencesManager.getToken(),nameText.text, seasonText.text, textValue.text,
                            bitmap
                        )
                    } else {
                        Toast.makeText(
                            context,
                            "Completa todos los campos.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } //if para verficar que esten todos los campos

                    delay(4000)

                    if (!viewModel.tournamentUiState.saveLeague.name.equals("")) {
                        navController.navigate("homeuser")

                        Toast.makeText(context, "Se ha registrado exitosamente", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(
                            context,
                            "al parecer hay un problema con tus datos, intenta de nuevo",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }

            },
            modifier = Modifier
                .fillMaxWidth().padding(15.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(3, 121, 255)
            ),
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Agregar Torneo",
                    tint = Color(255, 255, 255)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "CREAR", color = Color.White)
            }

        }
    }
}

@Composable
fun PhotoSelector() : Bitmap? {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri = uri
        }

    val selectedBitmap: Bitmap? by remember(selectedImageUri) {
        mutableStateOf(selectedImageUri?.let { loadBitmap(context.contentResolver, it) })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
                .clickable { launcher.launch("image/*") }
        ) {
            if (selectedBitmap != null) {
                Image(
                    bitmap = selectedBitmap!!.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            } else {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add Photo",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Click on the circle to select a photo",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
    return selectedBitmap
}

fun loadBitmap(contentResolver: ContentResolver, uri: Uri): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        ImageDecoder.decodeBitmap(
            ImageDecoder.createSource(contentResolver, uri)
        )
    } else {
        MediaStore.Images.Media.getBitmap(contentResolver, uri)
    }
}