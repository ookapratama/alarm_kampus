package com.example.alarm_kampus.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static  final  String DATA_USER = null;
    private static  final  String DATA_PASSWORD = null;
    private static  final  String DATA_API = "071994";

    private static final String BASE_URL = "https://service.undipa.ac.id/mhs.php/";

        private static Retrofit retrofit;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
