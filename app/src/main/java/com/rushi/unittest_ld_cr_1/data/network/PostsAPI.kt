package com.rushi.unittest_ld_cr_1.data.network

import com.rushi.unittest_ld_cr_1.data.dto.PostsDTO
import retrofit2.http.GET

interface PostsAPI {

    @GET("/posts")
    suspend fun getPosts() : PostsDTO
}