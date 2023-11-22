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
import com.example.laboratorio7.data.networking.Response.MatchResponseCreate
import com.example.laboratorio7.data.networking.Response.MatchResponseDelete
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


    var matchCreateUiState by mutableStateOf(
        MatchCreateUiState("")
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

    fun createMatch(token:String, id:String){
        matchCreateUiState = MatchCreateUiState(
            "", loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val removeMatch = repository.removeMatch(token,id)

                val createMatch = repository.createMatch(token,id, "2023-11-22")

                matchCreateUiState = MatchCreateUiState(date = createMatch.date, loading = false)
                Log.d("viewmodelMatch", "Response for match ${matchCreateUiState.date}")
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