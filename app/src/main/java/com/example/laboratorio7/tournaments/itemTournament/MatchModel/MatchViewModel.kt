package com.example.laboratorio7.tournaments.itemTournament.MatchModel


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
import com.example.laboratorio7.data.repository.SessionRepository
import com.example.laboratorio7.data.repository.UserRepository

class MatchViewModel(private val repository: SessionRepository = SessionRepository()) : ViewModel() {



    var matchUiState by mutableStateOf(
        MatchUiState(emptyList())
    )
        private set



    fun getSessions(token:String, id:String){
        matchUiState = MatchUiState(
            emptyList(), loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val sessionsResponse = repository.getSession(token,id)
                matchUiState = MatchUiState(session = sessionsResponse.session, loading = false)
                Log.d("viewmodelMatch", "Response for match ${matchUiState.session}")

            } catch (e: Exception) {
                // Maneja errores aquí

                Log.d("error", "Response for login ${                e.printStackTrace()
                }")

                matchUiState = MatchUiState(
                    emptyList(), loading = false)
            }
        }
    }
}