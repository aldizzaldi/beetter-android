package com.example.beetter.data.api;

import com.example.beetter.model.DataTeam;
import com.example.beetter.model.response.GetJoinedTeamResponse;
import com.example.beetter.model.response.GetUserResponse;
import com.example.beetter.model.response.LoginResponse;
import com.example.beetter.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IApiEndPoint {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String emailUser,
            @Field("password") String passwordUser
    );

    @GET("user")
    Call<GetUserResponse> getLogin(
            @Header("Authorization") String header,
            @Field("user") User user
    );

    @FormUrlEncoded
    @POST("team/team-list")
    Call<GetJoinedTeamResponse> getJoinedTeam(
            @Header("Authorization") String header
    );

}
