package com.example.beetter.ui.reportproductivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.example.beetter.model.dummy.DummyReportProductivity;
import com.example.beetter.model.dummy.DummyReportProductivityAdapter;
import com.example.beetter.model.dummy.DummyReportProductivityLuar;
import com.example.beetter.model.dummy.DummyReportProductivityLuarAdapter;

import java.util.ArrayList;

public class ReportProductivityFragment extends Fragment {
    private DummyReportProductivityAdapter dummyReportProductivityAdapter;
    private DummyReportProductivityLuarAdapter dummyReportProductivityLuarAdapter;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private ArrayList<DummyReportProductivity> dummyReportProductivities;
    private ArrayList<DummyReportProductivityLuar> dummyReportProductivityLuars;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.report_productivity, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);

//        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView4);
//        recyclerView2 = (RecyclerView) root.findViewById(R.id.recyclerView);
//        addData1();
//
//        dummyReportProductivityAdapter = new DummyReportProductivityAdapter(dummyReportProductivities);
//        recyclerView.setAdapter(dummyReportProductivityAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    void addData1(){
        dummyReportProductivities = new ArrayList<>();
        dummyReportProductivities.add(new DummyReportProductivity("Netbeans", "2h 3m 4s"));
        dummyReportProductivities.add(new DummyReportProductivity("Android", "2h 3m 4s"));
        dummyReportProductivities.add(new DummyReportProductivity("Netbeans", "2h 3m 4s"));


    }

    void addData2(){

    }
}