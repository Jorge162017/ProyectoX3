package com.example.laboratorio7.auth.UserModel

import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister

data class UserUiState (
    val user: UserDataResponse,
    val loading: Boolean = false,
    val executed: Boolean = false
)

data class UserUiStateRegister (
    val userSaved : UserDataResponseRegister,
    val loading: Boolean = false,
    val executed: Boolean = false

)