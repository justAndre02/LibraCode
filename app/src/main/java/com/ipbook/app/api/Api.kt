package com.ipbook.app.api

import com.ipbook.app.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Api {

    @POST("user/login")
    fun getUsers(
        @Body userLogin : UserLogin
    ): Call<UserLogin>

    @POST("user/signup")
    fun sendUserData(
        @Body sendUser: SendUser
    ): Call<SendUser>

    @DELETE("/user/logout")
    fun deleteToken(): Call<ResponseBody>

    @GET("/user/all")
    fun getAllUsers(): Call<List<AllUsers>>

    @PUT("/user/update/{id}")
    fun updateName(
        @Path("id") id : Int,
        @Body updateUser: UpdateUserName
    ): Call<UpdateUserName>

    @PUT("/user/updatepass/{id}")
    fun updatePassword(
        @Path("id") id : Int,
        @Body updateUser: UpdateUserPassword
    ): Call<UpdateUserPassword>

}