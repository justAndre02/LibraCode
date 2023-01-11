package com.ipbook.app.api

import com.ipbook.app.model.SendUser
import com.ipbook.app.model.User
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("user/all")
    fun getUsers(): Call<List<User>>

    @POST("user/signup")
    fun sendUserData(
        @Body sendUser: SendUser
    ): Call<SendUser>

}