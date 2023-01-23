package com.ipbook.app.api

import com.ipbook.app.db.Tables
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

    // Método utilizado para validar o login
    @POST("user/login")
    fun getUsers(
        @Body userLogin : UserLogin
    ): Call<UserLogin>


    // Método utilizado para registar um utilizador
    @POST("user/signup")
    fun sendUserData(
        @Body sendUser: SendUser
    ): Call<SendUser>

    // Método utilizado para realizar o logout
    @DELETE("/user/logout")
    fun deleteToken(): Call<ResponseBody>

    // Método Utilizado para receber os dados dos utilizadores
    @GET("/user/all")
    fun getAllUsers(): Call<List<AllUsers>>

    // Métudo utilizado para atualizar o nome do utilizador
    @PUT("/user/update/{id}")
    fun updateName(
        @Path("id") id : Int,
        @Body updateUser: UpdateUserName
    ): Call<UpdateUserName>

    // Método utilizado para atualizar a password do utilizador
    @PUT("/user/updatepass/{id}")
    fun updatePassword(
        @Path("id") id : Int,
        @Body updateUser: UpdateUserPassword
    ): Call<UpdateUserPassword>

    // Método utilizado para obter os dados dos livros
    @GET("/livro/all50")
    fun getLivros(): Call<MutableList<Book>>

    // Método utilizaod para realizar um empréstimo
    @POST("/user/make/{id}")
    fun doemprestimo(
        @Path("id") id: Int,
        @Body reserva: Reserva
    ): Call<Reserva>

    // Método utilizado para obter os empréstimos do utilizador
    @GET("/emprestimo/user/{id}")
    fun getEmprestimoUser(
        @Path("id") id: Int
    ): Call<MutableList<DadosReserva>>

}