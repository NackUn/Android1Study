package com.khb.searchmovie

import com.khb.searchmovie.model.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class NetworkHelper {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var movieApi = retrofit.create(MovieAPI::class.java)

    fun requestMovie(
        keyword: String,
        setTextView: (ArrayList<MovieEntity>) -> Unit
    ) {
        movieApi.getMovieList(keyword)
            .enqueue(object : Callback<SearchEntity> {
                override fun onFailure(call: Call<SearchEntity>, t: Throwable) {
                    println("실패 : $t")
                }

                override fun onResponse(call: Call<SearchEntity>, response: Response<SearchEntity>) {
                    println("응답 : $response")
                    println("메시지 : ${response.message()}")
                    response.body()?.items?.map {
                        println("내용 : ${it.title}")
                    }
                    setTextView(response.body()?.items as ArrayList<MovieEntity>)
                }
            })
    }
}