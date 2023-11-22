package com.example.laboratorio7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import com.example.laboratorio7.navigation.NavigationGraph
import com.example.laboratorio7.ui.theme.Laboratorio7Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Laboratorio7Theme {
                var sharedPreferencesManager: SharedPreferencesManager = SharedPreferencesManager(context)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,color = Color.Black
                ) {
                    if(sharedPreferencesManager.getToken().equals("") || sharedPreferencesManager.getToken().isNullOrBlank()){
                        NavigationGraph(defaultDestination="login")
                    }else{
                        NavigationGraph(defaultDestination="homeuser")

                    }

                }
            }
        }
    }
}

