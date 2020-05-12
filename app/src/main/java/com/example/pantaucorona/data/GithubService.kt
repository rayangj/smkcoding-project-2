package com.example.pantaucorona.data

import com.example.pantaucorona.GithubUserItem
import retrofit2.Call
import retrofit2.http.GET

   interface GithubService {
        @GET("users")
        fun getUsers(): Call<List<GithubUserItem>>
    }