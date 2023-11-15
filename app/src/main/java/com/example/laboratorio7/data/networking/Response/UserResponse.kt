package com.example.laboratorio7.data.networking.Response

import com.google.gson.annotations.SerializedName

data class UsersDataResponse(val users: List<UserResponse>)

data class UserDataResponse(val user: UserResponse, val token:String)

data class UserDataResponseRegister(val userSaved: UserResponse)


data class UserResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("role") val role: String,
    @SerializedName("email") val email: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("leagues") val leagues: Array<String>,
    @SerializedName("phone") val phone: String
)