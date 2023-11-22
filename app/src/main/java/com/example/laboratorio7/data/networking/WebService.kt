package com.example.laboratorio7.data.networking
import com.example.laboratorio7.data.networking.Response.PlayerDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister
import com.example.laboratorio7.data.networking.Response.leagueDataResponse
import com.example.laboratorio7.data.networking.Response.leaguesDataResponse
import com.example.laboratorio7.data.networking.Response.teamDataResponse
import com.example.laboratorio7.data.networking.Response.teamsDataResponse
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory


class WebService {

    private val api: Api

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tournament.workcodeinc.com:3800/torneo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

    //usuarios
    suspend fun login(username: String, password: String): UserDataResponse {
        return api.login(LoginRequest(username, password, true))
    }



    suspend fun saveUser(  name: String, lastname: String, username: String, email: String, phone: String, role: String, password:String): UserDataResponseRegister {
        return api.saveUser(
            RegisterRequest(
            name, lastname, username, email, phone, role, password)
        )

    }

    //ligas
    suspend fun getLeagues(  token: String): leaguesDataResponse {
        return api.getLeagues(token)
    }


    suspend fun saveLeague(  token: String, name:String, season:String, description:String): leagueDataResponse {
        return api.saveLeague(token, LeagueRequest(name, season, description))
    }
  //jugadores
    suspend fun getPlayersTeam(  token: String): PlayerDataResponse {
        return api.getPlayersTeam(token)
    }

    //equipos
    suspend fun getTeams(  token: String): teamsDataResponse{
        return api.getTeams(token)
    }

    suspend fun saveTeam(  token: String, name: String, players: Array<String>, gc: Number, gd: Number,
                              gf: Number, pe: Number, pg: Number, pj: Number, pp: Number, points: Number): teamDataResponse {
        return api.saveTeam(token, TeamRequest(name, players, gc, gd, gf, pe, pg, pj, pp, points))
    }

}