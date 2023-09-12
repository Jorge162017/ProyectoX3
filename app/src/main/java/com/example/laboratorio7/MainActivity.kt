package com.example.laboratorio7
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.PasswordVisualTransformation


import com.example.laboratorio7.ui.theme.Laboratorio7Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio7Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,color = Color.Black
                ) {
                    Login()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var textValue by remember { mutableStateOf(TextFieldValue(""))}
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
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
                    modifier = modifier,
                    fontSize = 40.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color.Black
                )
            ){
                Text(text = "Login",
                    color = Color.White)
            }
            Button(
                onClick = {
                    val intent = Intent(context, SignUp::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color.Black
                )
            ){
                Text(text = "Sign Up",
                    color = Color.White)
            }
        }
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Login",
                modifier = modifier.padding(start = 20.dp),
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
        Row {
            Icon(painter = painterResource(id = R.drawable.baseline_account_box_24),
                contentDescription = null,
                modifier = modifier.size(60.dp),
                tint =  Color(224, 225, 221)
            )
            TextField(
                value = textValue, // Utiliza textValue como el valor del TextField
                onValueChange = { newText ->
                    if (newText.text.length <= 10) {
                        textValue = newText // Actualiza textValue en lugar de text
                    }
                },
                label = { Text("Username (max 10 characters)") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                modifier = modifier
                    .height(60.dp)
                    .width(300.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(224, 225, 221))
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Icon(painter = painterResource(id = R.drawable.baseline_lock_24),
                contentDescription = null,
                modifier = modifier.size(60.dp),
                tint =  Color(224, 225, 221)
            )
            TextField(
                value = passwordText,
                onValueChange = { newText ->
                    if (newText.text.length <= 8) {
                        passwordText = newText
                    }
                },
                label = { Text("Password (max 8 characters)") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password, // Cambia a KeyboardType.Password
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = modifier
                    .height(60.dp)
                    .width(300.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(224, 225, 221))
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                if (isValidCredentials(textValue.text, passwordText.text)) {
                    val intent = Intent(context, Inicio::class.java)
                    context.startActivity(intent)
                } else {
                    // Mostrar mensaje de error o manejar la validación incorrecta
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Login")
        }
    }
}
// Función para validar las credenciales
fun isValidCredentials(username: String, password: String): Boolean {
    return username == "jorge" && password == "12345"
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Laboratorio7Theme {
        Login()
    }
}