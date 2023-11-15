package com.example.laboratorio7.data.networking
import com.example.laboratorio7.data.networking.Response.UserDataResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface  Api {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): UserDataResponse

}


data class LoginRequest(
    val username: String,
    val password: String,
    val getToken: Boolean
)