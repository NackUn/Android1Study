package com.khb.searchmovie.model

import com.khb.searchmovie.StringKeySet
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MovieAPI {
    @Headers(
        "X-Naver-Client-Id: ${StringKeySet.CLIENT_ID}",
        "X-Naver-Client-Secret: ${StringKeySet.CLIENT_SECRET}"
    )
    @GET("search/movie.json")
    fun getMovieList(
        @Query("query") query: String
    ): Call<ResponseBody>
}