package com.khb.searchmovie.model

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MovieAPI {
    @GET("search/{type}")
    fun getMovieList(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientPw: String,
        @Path("type") type: String,
        @Query("query") query: String
    ): Call<ResponseBody>
}