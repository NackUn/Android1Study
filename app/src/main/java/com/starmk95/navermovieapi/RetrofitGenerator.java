package com.starmk95.navermovieapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGenerator {
    // BASE_URL - 요청할 서버의 기본 url
    private final static String BASE_API_URL = "https://openapi.naver.com/";
    private static Retrofit mRetrofit = null;
    private static Gson gson = new GsonBuilder().create();

    private static HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder mOkHttpClientBuilder = new OkHttpClient.Builder()
            .addInterceptor(mHttpLoggingInterceptor);

    private static OkHttpClient mOkHttpClient = mOkHttpClientBuilder.build();

    public static <T> T createService(Class<T> serviceClass) {
        if (mRetrofit == null) {
            // Retrofit.Builder()를 통해 BASE_URL을 설정하고
            // 응답(json)을 객체로 변환하기 위한 gsonConverter도 설정해준다.
            mRetrofit = new Retrofit.Builder()
                    .client(mOkHttpClient)
                    .baseUrl(BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return mRetrofit.create(serviceClass);
    }

}
