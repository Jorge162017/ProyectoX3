package com.example.laboratorio7.auth

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.laboratorio7.MainActivity
import com.example.laboratorio7.R
import androidx.navigation.NavHostController
import com.example.laboratorio7.auth.UserModel.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController, viewModel: UserViewModel = viewModel()) {
    val context = LocalContext.current
    var textValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }

    var sharedPreferencesManager: SharedPreferencesManager = SharedPreferencesManager(context)
    val coroutineScope = CoroutineScope(Dispatchers.Main)
    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Surface (modifier = Modifier
            .height(130.dp)
            .fillMaxWidth(),
            color = Color(33, 37, 41)){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Bienvenido a X3",
                    modifier = Modifier,
                    fontSize = 40.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if (viewModel.userUiState.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {

            if (viewModel.userUiState.executed) {
                if (!viewModel.userUiState.user.token.equals("")) {
                    navController.navigate("homeuser")
                    sharedPreferencesManager.savetoken(viewModel.userUiState.user.token);
                    sharedPreferencesManager.saveObject(
                        "user",
                        viewModel.userUiState.user.user
                    )

                } else {
                    Toast.makeText(
                        context,
                        "Tus credenciales son incorrectas.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Login",
                        color = Color.White
                    )
                }
                Button(
                    onClick = {
                        navController.navigate("signup")
                    },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "LOGIN",
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(50.dp))
            }
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
                    label = {
                        Text(
                            "Username (max 10 characters)",
                            color = Color(120, 120, 122)
                        )
                    },
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
            Spacer(modifier = Modifier.height(40.dp))
            Divider(
                color = Color(120, 120, 122),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp)// Altura del Divider
            )
            Spacer(modifier = Modifier.height(30.dp))

            IconButton(

                onClick = {

                    coroutineScope.launch {
                        if (textValue.text.isEmpty() || passwordText.text.isEmpty()) {
                            viewModel.login(
                                textValue.text, passwordText.text
                            )
                        }else {
                            // Muestra un mensaje de error
                            Toast.makeText(
                                context,
                                "Completa todos los campos.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        //val result = viewModel.login(textValue.text, passwordText.text)
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
                        imageVector = Icons.Default.Send,
                        contentDescription = "Login",
                        tint = Color(255, 255, 255)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Login", color = Color.White)
                }

            }
        }
    }
}
// Función para validar las credenciales
fun isValidCredentials(username: String, password: String): Boolean {
    return username == "jorge" && password == "12345"
}
