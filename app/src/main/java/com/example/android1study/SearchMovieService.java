package com.example.android1study;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SearchMovieService {
    @Headers({
            "X-Naver-Client-Id: FMmoZHEfINxeYGn7TFo2",
            "X-Naver-Client-Secret: zE1dam2WLM"
    })
    @GET("search/movie.json")
    Single<SearchEntity> requestSearchMovie(@Query("query") String query);
}
