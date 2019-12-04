package com.example.beetter.data.api;

import com.example.beetter.model.response.GetDailyReportResponse;
import com.example.beetter.model.response.GetJoinedTeamResponse;
//import com.example.beetter.model.response.GetTeamMembers;
import com.example.beetter.model.response.GetListMemberInTeamResponse;
import com.example.beetter.model.response.GetTrackingReport;
import com.example.beetter.model.response.GetUserResponse;
import com.example.beetter.model.response.LoginResponse;
import com.example.beetter.model.User;

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

    @POST("team/team-list")
    Call<GetJoinedTeamResponse> getJoinedTeam(
            @Header("Authorization") String header
    );

//    @POST("team/member")
//    Call<GetTeamMembers> getTeamMembers(
//            @Header("Authorization") String header
//    );

//    @FormUrlEncoded
//    @POST("daily-tracking-report/overal-per-member-team")
//    Call<GetTrackingReport> getTrackReport(
//            @Header("Authorization") String header,
//            @Field("id_team") int id,
//            @Field("date") String date
//    );

    @FormUrlEncoded
    @POST("daily-scrum-report/list")
    Call<GetDailyReportResponse> getDailyReport(
            @Header("Authorization") String header,
            @Field("id_team") int id,
            @Field("date") String date
    );

    @FormUrlEncoded
    @POST("daily-tracking-report/overal-per-member-team")
    Call<GetListMemberInTeamResponse> getListMemberInTeam(
            @Header("Authorization") String header,
            @Field("id_team") int id,
            @Field("date") String date
    );

}
