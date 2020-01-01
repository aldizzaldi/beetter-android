package com.example.beetter.ui.reportproductivity;

import android.util.Log;

import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.GetTrackingReport;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportProductivityPresenter {
    private IReportProductivityView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public ReportProductivityPresenter(IReportProductivityView view) {
        this.view = view;
    }

    void getReportProductivity(){
        String token = SharedPrefUtils.getStringSharedPref("token", "");
        int idTeam = SharedPrefUtils.getIntSharedPref("id_team", 0);
        String date = "2020-01-1";

        apiEndPoint.getTrackingReport(token, date, idTeam).enqueue(new Callback<GetTrackingReport>() {
            @Override
            public void onResponse(Call<GetTrackingReport> call, Response<GetTrackingReport> response) {
                if(response.isSuccessful()){
                    ArrayList<ReportProductivityApps> reportProductivityApps = new ArrayList<>();
                    Log.e("jancok", "masuk cok");
                    int size = response.body().getReportProductivityApps().size();
                    for (int i = 0; i < size; i++){
                        reportProductivityApps.add(response.body().getReportProductivityApps().get(i));
                    }
                    view.getReportProductivity(reportProductivityApps);
                }
                else {
                    Log.e("jancok", "gamasuk cok");
                }
            }

            @Override
            public void onFailure(Call<GetTrackingReport> call, Throwable t) {
                Log.e("jancok", t.getCause() + "");
            }
        });
    }
}
