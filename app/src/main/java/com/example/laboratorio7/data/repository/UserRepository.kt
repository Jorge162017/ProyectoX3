package com.example.laboratorio7.data.repository


import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository( private val webService: WebService = WebService()) {

    suspend fun login(username:String, password:String): UserDataResponse{
        return withContext(Dispatchers.IO) {
            webService.login(username, password)
        }
    }

}