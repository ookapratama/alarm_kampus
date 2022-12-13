package com.example.alarm_kampus.api;

import com.example.alarm_kampus.model.login.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("mhs.php")
    Call<Login> loginResponse(
        @Field("username") String username,
        @Field("password") String password
    );

}
