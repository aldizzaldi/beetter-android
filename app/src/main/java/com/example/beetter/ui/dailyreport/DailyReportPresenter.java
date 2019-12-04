package com.example.beetter.ui.dailyreport;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.GetDailyReportResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DailyReportPresenter {
    private IDailyReportView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public DailyReportPresenter(IDailyReportView view) {
        this.view = view;
    }

    void getDailyReportToday(){
        String token = SharedPrefUtils.getStringSharedPref("token", "");
        int idTeam = SharedPrefUtils.getIntSharedPref("id_team", 0);
        String date = "2019-11-27";
        apiEndPoint.getDailyReport(token, idTeam, date).enqueue(new Callback<GetDailyReportResponse>() {
            @Override
            public void onResponse(Call<GetDailyReportResponse> call, Response<GetDailyReportResponse> response) {
                if(response.isSuccessful()){
                    ArrayList<DailyReport> dailyReports = new ArrayList<>();
                    Log.e("respon berhasil", response.body().toString());
                    int batas = response.body().getDataDailyReport().size();
                    for(int i = 0; i < batas; i++){
                        DailyReport dr = response.body().getDataDailyReport().get(i);
                        dailyReports.add(dr);
                    }
                    view.getDailyReport(dailyReports);
                }
                else{
                    Log.e("respon gagal", "daily report respon mu gagal");
                }
            }

            @Override
            public void onFailure(Call<GetDailyReportResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }
}
