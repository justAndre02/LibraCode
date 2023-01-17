package com.ipbook.app.api

import com.ipbook.app.data.UserDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("user/all")
    fun getUserData() : Call<List<UserDataItem>>

    @POST("user/login")
    fun postData(
        @Field("id") id : Int,
        @Field("nome") nome : String,
        @Field("email") email : String,
        @Field("password") password : String,
        @Field("nif") nif : Int,
        @Field("TipoUtilizador_id") TipoUtilizadorid : Int
    ) : Response<UserDataItem>
}