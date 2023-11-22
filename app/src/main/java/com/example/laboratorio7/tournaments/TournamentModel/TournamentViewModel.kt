package com.example.laboratorio7.tournaments.TournamentModel

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio7.data.networking.Response.LeagueResponse
import com.example.laboratorio7.data.repository.HomeRepository
import com.example.laboratorio7.user.HomeModel.HomeUiState
import kotlinx.coroutines.launch

class TournamentViewModel(private val repository: HomeRepository = HomeRepository()) : ViewModel() {



    var tournamentUiState by mutableStateOf(
        TournamentUiState(LeagueResponse("", emptyArray(), emptyArray(),"","","",""))
    )
        private set



    fun saveLeague(token:String, name:String, season:String, description:String, bitmap:Bitmap?){
        tournamentUiState = TournamentUiState(
            LeagueResponse("", emptyArray(), emptyArray(),"","","",""), loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val leagueResponse = repository.saveLeague(token,name,season,description)

                val imageRespon = repository.uploadImageLeague(bitmap,leagueResponse.saveLeague.id)


                tournamentUiState = TournamentUiState(saveLeague = leagueResponse.saveLeague, loading = false)



            } catch (e: Exception) {
                // Maneja errores aquí

                Log.d("error", "Response leagues ${                e.printStackTrace()
                }")

                tournamentUiState = TournamentUiState(
                    LeagueResponse("", emptyArray(), emptyArray(),"","","",""), loading = false)
            }
        }
    }
}