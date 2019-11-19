package com.example.beetter.data.api;

import com.example.beetter.model.LoginResponse;
import com.example.beetter.model.TestResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApiEndPoint {

    @FormUrlEncoded
    @GET("test")
    Call<TestResponse> test(
    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String emailUser,
            @Field("password") String passwordUser
    );

}
