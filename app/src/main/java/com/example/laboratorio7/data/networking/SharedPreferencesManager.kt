package com.example.laboratorio7.data.networking

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferencesManager(context: Context) {
     val sharedPreferences: SharedPreferences = context.getSharedPreferences("my_app_prefs", Context.MODE_PRIVATE)
     val gson = Gson()

    fun saveObject(key: String, obj: Any) {
        val json = gson.toJson(obj)
        sharedPreferences.edit().putString(key, json).apply()
    }

    inline fun <reified T> getObject(key: String): T? {
        val json = sharedPreferences.getString(key, null)
        return gson.fromJson(json, T::class.java)
    }

    fun savetoken(token: String){
        sharedPreferences.edit().putString("auth_token", token).apply()
    }

    fun getToken():String{
        return sharedPreferences.getString("auth_token","").toString()
    }
}