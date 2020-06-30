package com.shakatreh.nytimes.net;

import android.content.Context;
import com.shakatreh.nytimes.util.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/* This class built on Singleton pattern  */
public class ServiceProvider {

    private static ServiceProvider instance;
    private APIPaths apiPaths;

    private ServiceProvider() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS)
                .build();
        Retrofit.Builder retrofitBuilder=
                new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient);
        apiPaths = retrofitBuilder.build().create(APIPaths.class);
    }


    public static APIPaths getInstance(){
        if(instance == null)
            instance = new ServiceProvider();
        return instance.apiPaths;
    }
}
