package com.ipbook.app.api

import com.ipbook.app.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface Api {

    @GET("user/all")
    fun getUsers(): Call<List<User>>

}