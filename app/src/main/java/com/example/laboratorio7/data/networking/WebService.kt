package com.example.laboratorio7.data.networking
import android.graphics.Bitmap
import androidx.compose.ui.graphics.ImageBitmap
import com.example.laboratorio7.data.networking.Response.PlayerDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponse
import com.example.laboratorio7.data.networking.Response.UserDataResponseRegister
import com.example.laboratorio7.data.networking.Response.leagueDataResponse
import com.example.laboratorio7.data.networking.Response.leagueImageDataResponse
import com.example.laboratorio7.data.networking.Response.leagueTeamDataResponse
import com.example.laboratorio7.data.networking.Response.leaguesDataResponse
import com.example.laboratorio7.data.networking.Response.sessionsDataResponse
import com.example.laboratorio7.data.networking.Response.teamDataResponse
import com.example.laboratorio7.data.networking.Response.teamsDataResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


class WebService {

    private val api: Api

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tournament.workcodeinc.com:3800/torneo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

    //usuarios
    suspend fun login(username: String, password: String): UserDataResponse {
        return api.login(LoginRequest(username, password, true))
    }



    suspend fun saveUser(  name: String, lastname: String, username: String, email: String, phone: String, role: String, password:String): UserDataResponseRegister {
        return api.saveUser(
            RegisterRequest(
            name, lastname, username, email, phone, role, password)
        )

    }

    //ligas
    suspend fun getLeagues(  token: String): leaguesDataResponse {
        return api.getLeagues(token)
    }


    suspend fun uploadImageLeague(  bitmap: Bitmap?, id:String): leagueImageDataResponse {
        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val byteArray = stream.toByteArray()

        val tempFile = File.createTempFile("tempImage", ".jpg")
        val fos = FileOutputStream(tempFile)
        fos.write(byteArray)
        fos.flush()
        fos.close()

        // Crear el RequestBody y MultipartBody.Part
        val requestFile = tempFile.asRequestBody("image/*".toMediaTypeOrNull())
        val imagePart = MultipartBody.Part.createFormData("image", tempFile.name, requestFile)

        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart(
                "image",
                tempFile.name,
                RequestBody.create("image/*".toMediaTypeOrNull(), byteArray)
            ).build()
        return api.uploadImageLeague(id, requestBody)
    }

    suspend fun saveLeague(  token: String, name:String, season:String, description:String): leagueDataResponse {
        return api.saveLeague(token, LeagueRequest(name, season, description))
    }
  //jugadores
    suspend fun getPlayersTeam(  token: String): PlayerDataResponse {
        return api.getPlayersTeam(token)
    }

    //equipos
    suspend fun getLeagueTeam(  token: String, id:String): leagueTeamDataResponse {
        return api.getLeagueTeam(token,id)
    }

    suspend fun saveTeam(  token: String, name: String, players: Array<String>, gc: Number, gd: Number,
                              gf: Number, pe: Number, pg: Number, pj: Number, pp: Number, points: Number): teamDataResponse {
        return api.saveTeam(token, TeamRequest(name, players, gc, gd, gf, pe, pg, pj, pp, points))
    }


    //session
    suspend fun getSession(token: String,   id:String): sessionsDataResponse {

        return api.getSession(token,id)
    }

}