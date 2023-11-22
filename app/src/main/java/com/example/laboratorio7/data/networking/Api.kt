package com.example.laboratorio7.data.networking
import androidx.compose.ui.platform.LocalContext
import com.example.laboratorio7.data.networking.Response.PlayerDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister
import com.example.laboratorio7.data.networking.Response.leagueDataResponse
import com.example.laboratorio7.data.networking.Response.leaguesDataResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface  Api {


    //usuarios
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): UserDataResponse


    @POST("saveUser")
    suspend fun saveUser(@Body registerRequest: RegisterRequest): UserDataResponseRegister

    //ligas

    @GET("getLeagues")
    suspend fun getLeagues(@Header("Authorization") authorizationHeader: String): leaguesDataResponse


    @GET("getPlayersTeam")
    suspend fun getPlayersTeam(@Header("Authorization") authorizationHeader: String): PlayerDataResponse


    @POST("saveLeague")
    suspend fun saveLeague(@Header("Authorization") authorizationHeader: String, @Body leagueRequest: LeagueRequest): leagueDataResponse

}

//user
data class LoginRequest(
    val username: String,
    val password: String,
    val getToken: Boolean
)

data class RegisterRequest(
    val name: String,
    val lastname: String,
    val username: String,
    val email: String,
    val phone: String,
    val role: String,
    val password: String
)

//leagues
data class LeagueRequest(
    val name: String,
    val season: String,
    val description: String
)


data class PlayerRequest(
    val name: String,
    val season: String,
    val description: String
)