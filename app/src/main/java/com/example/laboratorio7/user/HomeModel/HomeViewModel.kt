package com.example.laboratorio7.user.HomeModel


import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio7.auth.UserModel.UserUiState
import com.example.laboratorio7.auth.UserModel.UserUiStateRegister
import kotlinx.coroutines.launch


import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister
import com.example.laboratorio7.data.networking.Response.UserResponse
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import com.example.laboratorio7.data.repository.HomeRepository
import com.example.laboratorio7.data.repository.UserRepository

class HomeViewModel(private val repository: HomeRepository = HomeRepository()) : ViewModel() {



    var homeUiState by mutableStateOf(
        HomeUiState(emptyList())
    )
        private set



    fun getLeagues(token:String){
        homeUiState = HomeUiState(
            emptyList(), loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val leagueResponse = repository.getLeagues(token)
                homeUiState = HomeUiState(leagues = leagueResponse.leagues, loading = false)

                Log.d("viewmodelhome", "Response for login ${homeUiState.leagues}")


            } catch (e: Exception) {
                // Maneja errores aquí

                Log.d("error", "Response for login ${                e.printStackTrace()
                }")

                homeUiState = HomeUiState(
                    emptyList(), loading = false)
            }
        }
    }
}