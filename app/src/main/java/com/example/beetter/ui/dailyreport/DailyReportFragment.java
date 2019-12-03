package com.example.beetter.ui.dailyreport;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyReportFragment extends Fragment implements IDailyReportView{

    private DailyReportPresenter presenter;
    private DailyReportAdapter dailyReportAdapter;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.daily_report, container, false);
//        ButterKnife.bind(this, root);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewDailyReport);
        presenter = new DailyReportPresenter(this);
        presenter.getDailyReportToday();
        return root;
    }

    @Override
    public void getDailyReport(ArrayList<DailyReport> dailyReports) {
        dailyReportAdapter = new DailyReportAdapter(dailyReports, getContext());
        Log.e("daily", dailyReports.size() + "!");
        recyclerView.setAdapter(dailyReportAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}