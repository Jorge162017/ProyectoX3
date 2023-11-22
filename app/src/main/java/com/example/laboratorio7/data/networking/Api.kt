package com.example.laboratorio7.data.networking
import com.example.laboratorio7.data.networking.Response.PlayerDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister
import com.example.laboratorio7.data.networking.Response.leagueDataResponse
import com.example.laboratorio7.data.networking.Response.leagueImageDataResponse
import com.example.laboratorio7.data.networking.Response.leaguesDataResponse
import com.example.laboratorio7.data.networking.Response.teamDataResponse
import com.example.laboratorio7.data.networking.Response.teamsDataResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface  Api {


    //usuarios
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): UserDataResponse


    @POST("saveUser")
    suspend fun saveUser(@Body registerRequest: RegisterRequest): UserDataResponseRegister

    //ligas
    @PUT("uploadLeague/{id}")
    suspend fun uploadImageLeague(@Path("id") id: String, @Body body: RequestBody): leagueImageDataResponse

    @GET("getLeagues")
    suspend fun getLeagues(@Header("Authorization") authorizationHeader: String): leaguesDataResponse


    @GET("getPlayersTeam")
    suspend fun getPlayersTeam(@Header("Authorization") authorizationHeader: String): PlayerDataResponse


    @POST("saveLeague")
    suspend fun saveLeague(@Header("Authorization") authorizationHeader: String, @Body leagueRequest: LeagueRequest): leagueDataResponse

    //equipos

    @GET("getTeams")
    suspend fun getTeams(@Header("Authorization") authorizationHeader: String): teamsDataResponse

    @POST("saveTeam")
    suspend fun saveTeam(@Header("Authorization") authorizationHeader: String, @Body teamRequest: TeamRequest): teamDataResponse

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
//teams
data class TeamRequest(
    val name: String,
    val players: Array<String>,
    val gc: Number,
    val gd: Number,
    val gf: Number,
    val pe: Number,
    val pg: Number,
    val pj: Number,
    val pp: Number,
    val points: Number,
)