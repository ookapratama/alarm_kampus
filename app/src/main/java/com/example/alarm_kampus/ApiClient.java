package com.example.alarm_kampus;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final  String BASE_URL  = "https://service.undipa.ac.id/";
    private static Retrofit retrofit;

    public  static Retrofit getRetrofit() {


        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }

}