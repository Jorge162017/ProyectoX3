package com.example.laboratorio7.data.networking
import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister
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



    suspend fun saveUser(  name: String, lastname: String, username: String, email: String, phone: String, role: String, password:String): UserDataResponseRegister {
        return api.saveUser(
            RegisterRequest(
            name, lastname, username, email, phone, role, password)
        )

    }

}