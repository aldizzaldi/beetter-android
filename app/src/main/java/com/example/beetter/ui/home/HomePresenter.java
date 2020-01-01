package com.example.beetter.ui.home;

import android.util.Log;

import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.GetListMemberInTeamResponse;
import com.example.beetter.model.response.SendPokeResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private IHomeView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);
    ArrayList<HomeReportProductivity> reportProductivities = new ArrayList<>();
    int size = 0;
    double overall = 0;
    int idTeam;
    String token;
    String description;

    public HomePresenter(IHomeView view) {
        this.view = view;
    }

    void getListMemberInTeam(){
        token = SharedPrefUtils.getStringSharedPref("token", "");
        idTeam = SharedPrefUtils.getIntSharedPref("id_team", 0);
        String date = "2019-11-27";

        apiEndPoint.getListMemberInTeam(token,idTeam,date).enqueue(new Callback<GetListMemberInTeamResponse>() {
            @Override
            public void onResponse(Call<GetListMemberInTeamResponse> call, Response<GetListMemberInTeamResponse> response) {
                if(response.isSuccessful()){
                    size = response.body().getReportProductivities().size();
                    Log.e("ukuran", "" + size);
                    for(int i =0; i < size; i++){
                        Log.e("Berhasil masuk", "yey");
                        reportProductivities.add(response.body().getReportProductivities().get(i));
                        overall =  overall + response.body().getReportProductivities().get(i).getValue().getProductiveValue();
                    }
                    view.getTeamMember(reportProductivities);
                    overall = overall/size;
                    Math.round(overall);

                    view.showOverallProductivitiesTeam(overall);
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

    void poke(int idTeam, int idUser){

        apiEndPoint.sendPoke(token, idTeam, idUser).enqueue(new Callback<SendPokeResponse>() {
            @Override
            public void onResponse(Call<SendPokeResponse> call, Response<SendPokeResponse> response) {
                if(response.isSuccessful()){
                    description = response.body().getPoke().getContent();
                    view.showError(description);
                }
            }

            @Override
            public void onFailure(Call<SendPokeResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }

//    void showOverallProductivity(){
//        Log.e("overall", "" + overall);
//        overall = overall/size;
//        Math.round(overall);
//
//        view.showOverallProductivitiesTeam(overall);
//
//        Log.e("ukuran2", "" + size);
//    }
}
