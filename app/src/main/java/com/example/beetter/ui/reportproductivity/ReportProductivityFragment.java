package com.example.beetter.ui.reportproductivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportProductivityFragment extends Fragment implements IReportProductivityView{

    private ReportProductivityPresenter presenter;
    private ReportProductivityAdapter reportProductivityAdapter;
    private RecyclerView recyclerViewHorizontal;
    private View root;

    @BindView(R.id.showDateReportProductivity)
    TextView showDate;
    @BindView(R.id.btnDateReportProductivity)
    ImageButton btnDate;

    Calendar myCalendar;
    DatePickerDialog datePickerDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.report_productivity, container, false);
        presenter = new ReportProductivityPresenter(this);
        presenter.getReportProductivity();
        ButterKnife.bind(this, root);
        btnDate.setOnClickListener(listener);

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

    @Override
    public void getReportProductivity(ArrayList<ReportProductivityApps> reportProductivityApps) {
        recyclerViewHorizontal = (RecyclerView) root.findViewById(R.id.recyclerViewReportProductivity);
        reportProductivityAdapter = new ReportProductivityAdapter(reportProductivityApps, getContext());
        Log.e("Report", reportProductivityApps.size() + "!!");
        recyclerViewHorizontal.setAdapter(reportProductivityAdapter);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showError(String message) {

    }

    ImageButton.OnClickListener listener = new ImageButton.OnClickListener() {
        @Override
        public void onClick(View view) {
            myCalendar = Calendar.getInstance();
            int day = myCalendar.get(Calendar.DAY_OF_MONTH);
            int month = myCalendar.get(Calendar.MONTH);
            int year = myCalendar.get(Calendar.YEAR);

            datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(android.widget.DatePicker datePicker, int mYear, int mMonth, int mDay) {
                    showDate.setText(mYear + "-" + mMonth + "-" + mDay);
                }
            }, year, month, day);
            datePickerDialog.show();
        }
    };
}