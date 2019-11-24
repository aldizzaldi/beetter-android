package com.example.beetter.ui.listteam;

import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.GetJoinedTeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTeamPresenter {
    private IListTeamView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public ListTeamPresenter(IListTeamView view) {
        this.view = view;
    }

    void getListTeam(){
        apiEndPoint.getJoinedTeam(SharedPrefUtils.getStringSharedPref("email", "")).enqueue(new Callback<GetJoinedTeamResponse>() {
            @Override
            public void onResponse(Call<GetJoinedTeamResponse> call, Response<GetJoinedTeamResponse> response) {

            }

            @Override
            public void onFailure(Call<GetJoinedTeamResponse> call, Throwable t) {

            }
        });
    }
}
