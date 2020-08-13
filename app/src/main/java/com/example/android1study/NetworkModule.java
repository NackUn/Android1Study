package com.example.android1study;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    private Retrofit retrofit;
    private static final String NAVER_URL = "https://openapi.naver.com/v1/";

    private NetworkModule() {
        retrofit = new Retrofit.Builder()
                .baseUrl(NAVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private static class NetworkModuleHolder {
        public static final NetworkModule NETWORK_MODULE = new NetworkModule();
    }

    public static NetworkModule getNetworkModule() {
        return NetworkModuleHolder.NETWORK_MODULE;
    }

}
