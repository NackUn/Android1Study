package com.khb.searchmovie

import com.khb.searchmovie.model.Movie
import com.khb.searchmovie.model.MovieAPI
import com.khb.searchmovie.model.MovieDetail
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkHelper {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var movieApi = retrofit.create(MovieAPI::class.java)

    fun requestMovie(
        keyword: String,
        setTextView: (ArrayList<MovieDetail>) -> Unit
    ) {
        movieApi.getMovieList(keyword)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    println("실패 : $t")
//                    println("실패 : ${t.message}")
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    println("응답 : $response")
                    println("메시지 : ${response.message()}")
                    println("내용 : ${response.body()}")

//                    response.body()?.items?.let { setTextView(it) }
                }
            })
    }
}