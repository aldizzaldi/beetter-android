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
        apiEndPoint.getDailyReport(SharedPrefUtils.getStringSharedPref("token", ""), SharedPrefUtils.getIntSharedPref("id_team", 0), "2019-11-21").enqueue(new Callback<GetDailyReportResponse>() {
            @NonNull
            @Override
            public void onResponse(Call<GetDailyReportResponse> call, Response<GetDailyReportResponse> response) {
                if(response.isSuccessful()){
                    ArrayList<DailyReport> dailyReports = new ArrayList<>();
                    Log.e("respon berhasil", "daily report respon mu berhasil");
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

            }
        });
    }
}
