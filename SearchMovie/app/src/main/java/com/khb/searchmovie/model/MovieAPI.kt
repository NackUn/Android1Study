package com.khb.searchmovie.model

import com.khb.searchmovie.StringKeySet
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieAPI {
    @Headers(
        "X-Naver-Client-Id: Z6OHzyRe_5anc4FWCoq2",
        "X-Naver-Client-Secret: pSumWoEXFY"
    )
    @GET("search/movie.json")
    fun getMovieList(
        @Query("query") query: String
    ): Call<SearchEntity>
}