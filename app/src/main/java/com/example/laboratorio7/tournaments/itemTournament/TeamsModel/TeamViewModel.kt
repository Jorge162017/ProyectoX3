package com.example.laboratorio7.tournaments.itemTournament.TeamsModel

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio7.data.networking.Response.LeagueResponseTeam
import com.example.laboratorio7.data.networking.Response.TeamResponse
import com.example.laboratorio7.data.repository.SessionRepository
import com.example.laboratorio7.data.repository.TeamRepository
import com.example.laboratorio7.tournaments.itemTournament.MatchModel.MatchUiState
import kotlinx.coroutines.launch

class TeamViewModel(private val repository: TeamRepository = TeamRepository()) : ViewModel() {



    var teamUiState by mutableStateOf(
        TeamUiState(LeagueResponseTeam("", emptyArray(), emptyArray(),"","","",""))
    )
        private set


    var teamSaveUiState by mutableStateOf(
        TeamSaveUiState(TeamResponse("", emptyArray(),"",0,0,0,0,0,0,0,0,""))
    )
        private set


    var positionUiState by mutableStateOf(
        PositionUiState(emptyList())
    )
        private set



    fun getTeams(token:String, id:String){
        teamUiState = TeamUiState(
            LeagueResponseTeam("", emptyArray(), emptyArray(),"","","",""), loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val teamResponse = repository.getLeagueTeam(token,id)
                teamUiState = TeamUiState(ls = teamResponse.ls, loading = false)
                Log.d("teams", "Response for team ${                teamUiState.ls
                }")

            } catch (e: Exception) {
                // Maneja errores aquí

                Log.d("error", "Response for login ${                e.printStackTrace()
                }")

                teamUiState = TeamUiState(
                    LeagueResponseTeam("", emptyArray(), emptyArray(),"","","",""), loading = false)
            }
        }
    }


    fun listaPosition(token:String, id:String){
        positionUiState = PositionUiState(
            emptyList(), loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val teamResponse = repository.listaPosition(token,id)
                positionUiState = PositionUiState(teams = teamResponse.teams, loading = false)
                Log.d("teams", "Response for team ${                positionUiState.teams
                }")

            } catch (e: Exception) {
                // Maneja errores aquí

                Log.d("error", "Response for login ${                e.printStackTrace()
                }")

                positionUiState = PositionUiState(
                    emptyList(), loading = false)
            }
        }
    }


    fun saveTeam(token:String, id:String, name:String){
        teamSaveUiState = TeamSaveUiState(
            TeamResponse("", emptyArray(),"",0,0,0,0,0,0,0,0,""), loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val teamResponse = repository.saveTeam(token, name)

                val setTeamResponse = repository.setTeamLeague(token,id,teamResponse.saveTeam.id)

                teamSaveUiState = TeamSaveUiState(saveTeam = teamResponse.saveTeam, loading = false)



                Log.d("teams", "Response for team ${                teamSaveUiState.saveTeam
                }")

            } catch (e: Exception) {
                // Maneja errores aquí

                Log.d("error", "Response for login ${                e.printStackTrace()
                }")

                teamSaveUiState = TeamSaveUiState(
                    TeamResponse("", emptyArray(),"",0,0,0,0,0,0,0,0,""), loading = false)
            }
        }
    }

}