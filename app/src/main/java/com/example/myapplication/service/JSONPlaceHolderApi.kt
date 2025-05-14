package com.example.myapplication.service

import com.example.myapplication.models.PostListItem
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("posts")
    fun getPosts(): Call<List<PostListItem>>
}