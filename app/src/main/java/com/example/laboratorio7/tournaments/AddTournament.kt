package com.example.laboratorio7.tournaments

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.graphics.Color
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
import com.example.laboratorio7.user.HomeModel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTournament(navController: NavHostController) {
    val context = LocalContext.current

    var nameText by remember { mutableStateOf(TextFieldValue("")) }
    var lastnameText by remember { mutableStateOf(TextFieldValue("")) }
    var textValue by remember { mutableStateOf(TextFieldValue("")) }
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    var phoneText by remember { mutableStateOf(TextFieldValue("")) }
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

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "AGREGAR TORNEO",
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
                painter = painterResource(id = R.drawable.baseline_account_box_24),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = nameText,
                onValueChange = { newText ->
                    if (newText.text.length <= 10) {
                        nameText = newText
                    }
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

        // apellido

        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_account_box_24),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = lastnameText,
                onValueChange = { newText ->
                    if (newText.text.length <= 10) {
                        lastnameText = newText
                    }
                },
                label = { Text("Apellido", color = Color(120, 120, 122)) },
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

        //username
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_account_box_24),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = textValue, // Utiliza textValue como el valor del TextField
                onValueChange = { newText ->
                    if (newText.text.length <= 10) {
                        textValue = newText // Actualiza textValue en lugar de text
                    }
                },
                label = { Text("Username", color = Color(120, 120, 122)) },
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

        //password
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_lock_24),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = passwordText,
                onValueChange = { newText ->
                    if (newText.text.length <= 8) {
                        passwordText = newText
                    }
                },
                label = {
                    Text(
                        "Password (max 8 characters)", color = Color(120, 120, 122)
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier,

                shape = RoundedCornerShape(2.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(120, 120, 122),
                    unfocusedIndicatorColor = Color(120, 120, 122),
                    containerColor = Color(47, 47, 49)
                ),


                )
        }
        Spacer(modifier = Modifier.height(30.dp))
        //email
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_account_box_24),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = emailText,
                onValueChange = { newText ->
                    if (newText.text.length <= 10) {
                        emailText = newText
                    }
                },
                label = { Text("Email", color = Color(120, 120, 122)) },
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

        //phone
        Row {
            Icon(
                painter = painterResource(id = R.drawable.phone),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color(47, 47, 49)
            )
            TextField(
                value = phoneText, // Utiliza textValue como el valor del TextField
                onValueChange = { newText ->
                    if (newText.text.length <= 10) {
                        phoneText = newText // Actualiza textValue en lugar de text
                    }
                },
                label = { Text("Phone", color = Color(120, 120, 122)) },
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


        Spacer(modifier = Modifier.height(30.dp))
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
                    contentDescription = "Register",
                    tint = Color(255, 255, 255)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Register", color = Color.White)
            }

        }
    }
}