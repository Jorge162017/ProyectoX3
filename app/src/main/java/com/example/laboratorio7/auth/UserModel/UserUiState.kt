package com.example.laboratorio7.auth.UserModel

import com.example.laboratorio7.data.networking.Response.UserDataResponse

data class UserUiState (
    val user: UserDataResponse,
    val loading: Boolean = false
)