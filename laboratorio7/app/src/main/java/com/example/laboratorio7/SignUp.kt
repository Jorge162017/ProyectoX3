package com.example.laboratorio7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio7.ui.theme.Laboratorio7Theme

class SignUp: ComponentActivity() {override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        Laboratorio7Theme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize() ,color = Color.Black
            ) {
                SignUp()
            }
        }
    }
}
}

@Composable
fun SignUp(modifier: Modifier = Modifier) {
    Text(
        text = "Sign Up",
        modifier = modifier,
        fontSize = 40.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold
        )
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    Laboratorio7Theme {
        SignUp()
    }
}