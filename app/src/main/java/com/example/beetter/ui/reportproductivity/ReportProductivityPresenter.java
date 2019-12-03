package com.example.beetter.ui.reportproductivity;

import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;

public class ReportProductivityPresenter {
    private IReportProductivityView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public ReportProductivityPresenter(IReportProductivityView view) {
        this.view = view;
    }
}
