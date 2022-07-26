package com.example.photoworld.data.api

import com.example.photoworld.CLIENT_ID
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhoto(
        @Query("query")query:String,
        @Query("page")page:Int,
        @Query("per_page")perPage:Int
    ):PhotoResponse
}