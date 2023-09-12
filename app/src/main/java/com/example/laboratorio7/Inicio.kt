package com.example.laboratorio7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.laboratorio7.ui.theme.Laboratorio7Theme

class Inicio: ComponentActivity() {override fun onCreate(savedInstanceState: Bundle?)  {
    super.onCreate(savedInstanceState)
    setContent {
        Laboratorio7Theme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize() ,color = Color.Black
            ) {
                Inicio()
            }
        }
    }
}
}

@Composable
fun Inicio(modifier: Modifier = Modifier) {
    Text(
        text = "Inicio",
        modifier = modifier,
        fontSize = 40.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun InicioPreview() {
    Laboratorio7Theme {
        Inicio()
    }
}