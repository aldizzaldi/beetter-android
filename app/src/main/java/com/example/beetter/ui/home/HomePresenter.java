package com.example.beetter.ui.home;

import android.util.Log;

import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.GetListMemberInTeamResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private IHomeView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public HomePresenter(IHomeView view) {
        this.view = view;
    }

    void getListMemberInTeam(){
        String token = SharedPrefUtils.getStringSharedPref("token", "");
        int idTeam = SharedPrefUtils.getIntSharedPref("id_team", 0);
        String date = "2019-11-27";
        apiEndPoint.getListMemberInTeam(token,idTeam,date).enqueue(new Callback<GetListMemberInTeamResponse>() {
            @Override
            public void onResponse(Call<GetListMemberInTeamResponse> call, Response<GetListMemberInTeamResponse> response) {
                if(response.isSuccessful()){
                    ArrayList<HomeReportProductivity> reportProductivities = new ArrayList<>();
                    for(int i =0; i < response.body().getReportProductivities().size(); i++){
                        Log.e("Berhasil masuk", "yey");
                        reportProductivities.add(response.body().getReportProductivities().get(i));
                    }
                    view.getTeamMember(reportProductivities);
                }
                else{
                    Log.e("gagal masuk", "sad");
                }
            }

            @Override
            public void onFailure(Call<GetListMemberInTeamResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }
}
