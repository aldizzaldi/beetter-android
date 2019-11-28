package com.example.beetter.ui.listteam;

import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.GetJoinedTeamResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTeamPresenter {
    private IListTeamView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);
    private ArrayList<DataTeam> dataTeams;

    public ListTeamPresenter(IListTeamView view) {
        this.view = view;
    }

    void getListTeam(){
        apiEndPoint.getJoinedTeam(SharedPrefUtils.getStringSharedPref("token", "")).enqueue(new Callback<GetJoinedTeamResponse>() {
            @Override
            public void onResponse(Call<GetJoinedTeamResponse> call, Response<GetJoinedTeamResponse> response) {
                String email = SharedPrefUtils.getStringSharedPref("email", "");

                for(int i = 0 ; i < response.body().getDataTeams().size(); i++){
                    if(email.equalsIgnoreCase(response.body().getDataTeams().get(i).user.getEmail())){
                        dataTeams.add(response.body().getDataTeams().get(i));
                    }

                }
            }

            @Override
            public void onFailure(Call<GetJoinedTeamResponse> call, Throwable t) {
                    view.showError(t.getMessage());
            }
        });
    }
}
