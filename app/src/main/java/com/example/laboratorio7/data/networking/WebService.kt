package com.example.laboratorio7.data.networking
import com.example.laboratorio7.data.networking.Response.UserDataResponse
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


    suspend fun login(username: String, password: String): UserDataResponse {
        return api.login(LoginRequest(username, password, true))
    }
}