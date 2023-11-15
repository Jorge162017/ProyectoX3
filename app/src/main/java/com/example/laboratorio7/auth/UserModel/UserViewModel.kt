package com.example.laboratorio7.auth.UserModel


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserResponse
import com.example.laboratorio7.data.networking.SharedPreferencesManager
import com.example.laboratorio7.data.repository.UserRepository

class UserViewModel(private val repository: UserRepository = UserRepository()) : ViewModel() {



    var userUiState by mutableStateOf(UserUiState(UserDataResponse(
        UserResponse(
            "","","","","","","", emptyArray(),""
        ), ""
    )))
        private set

    fun login(username:String, password:String){
        userUiState = UserUiState(
            UserDataResponse(UserResponse(
            "","","","","","","", emptyArray(),""
            ), "")
            , loading = true)

        viewModelScope.launch {
            // Aquí deberías realizar la lógica de inicio de sesión con el repositorio
            try {
                val userResponse = repository.login(username, password)
                userUiState = UserUiState(userResponse, loading = false)

                Log.d("viewModelUser", "Response for login ${userUiState.user.token}")


            } catch (e: Exception) {
                // Maneja errores aquí

                Log.d("error", "Response for login ${                e.printStackTrace()
                }")

                userUiState = UserUiState( UserDataResponse(UserResponse(
                    "","","","","","","", emptyArray(),""
                ),""), loading = false)
            }
        }
    }
}