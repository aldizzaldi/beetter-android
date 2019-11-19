package com.example.beetter.data.api;

import com.example.beetter.model.DataTeam;
import com.example.beetter.model.GetJoinedTeamResponse;
import com.example.beetter.model.GetUserResponse;
import com.example.beetter.model.LoginResponse;
import com.example.beetter.model.TestResponse;
import com.example.beetter.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApiEndPoint {

    @GET("test")
    Call<TestResponse> test(
    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String emailUser,
            @Field("password") String passwordUser
    );

    @GET("user")
    Call<GetUserResponse> getLogin(
            @Field("user") User user
    );

    @FormUrlEncoded
    @POST("team/team-list")
    Call<GetJoinedTeamResponse> getJoinedTeam(
            @Field("success") Boolean status,
            @Field("dataTeam") List<DataTeam> dataTeam
    );

}
