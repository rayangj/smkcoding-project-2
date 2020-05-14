package com.example.pantaucorona.data

import com.example.pantaucorona.NegaraApiItem
import retrofit2.Call
import retrofit2.http.GET

   interface NegaraService {
        @GET(".")
        fun getUsers(): Call<List<NegaraApiItem>>
    }