package com.example.laboratorio7.data.repository


import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister
import com.example.laboratorio7.data.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository( private val webService: WebService = WebService()) {

    suspend fun login(username:String, password:String): UserDataResponse{
        return withContext(Dispatchers.IO) {
            webService.login(username, password)
        }
    }


    suspend fun saveUser( name: String, lastname: String, username: String, email: String, phone: String, role: String, password: String): UserDataResponseRegister{
        return withContext(Dispatchers.IO) {
            webService.saveUser(name,lastname, username, email, phone, role, password)
        }
    }
}