package com.example.beetter.data.api;

import com.example.beetter.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IApiEndPoint {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("username") String usernameUser,
            @Field("password") String passwordUser
    );

}
