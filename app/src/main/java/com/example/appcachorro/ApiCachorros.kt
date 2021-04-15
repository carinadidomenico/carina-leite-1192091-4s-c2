package com.example.appcachorro


import retrofit2.Call
import retrofit2.http.*

interface ApiCachorros {

    @GET("cachorros/{id}")
    fun get(@Path("id") id:Int): Call<Cachorro>

}