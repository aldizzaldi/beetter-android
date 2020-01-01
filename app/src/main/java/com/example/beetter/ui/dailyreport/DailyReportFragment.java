package com.example.beetter.ui.dailyreport;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.example.beetter.model.dummy.DummyDailyAdapter;
import com.example.beetter.model.dummy.DummyDailyReport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyReportFragment extends Fragment implements IDailyReportView {

    private DailyReportPresenter presenter;
    private DailyReportAdapter dailyReportAdapter;
    private RecyclerView recyclerView;
    private View root;

    @BindView(R.id.btnDateDailyReport)
    ImageButton btnDate;
    @BindView(R.id.showDateDailyReport)
    TextView showDate;

    Calendar myCalendar;
    DatePickerDialog datePickerDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.daily_report, container, false);
        presenter = new DailyReportPresenter(this);
        presenter.getDailyReportToday();
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
    public void getDailyReport(ArrayList<DailyReport> dailyReports) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewDailyReport);
        dailyReportAdapter = new DailyReportAdapter(dailyReports, getContext());
        Log.e("daily", dailyReports.size() + "!");
        recyclerView.setAdapter(dailyReportAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
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

//    void addData(){
//        dailyReportList = new ArrayList<>();
//        dailyReportList.add(new DummyDailyReport("Buddy","Kemarin saya gabut", "Jadi saya merubah rencana, menegerjakan di kamopus", "Charger saya ketinggalan" ));
//        dailyReportList.add(new DummyDailyReport("Steven","Kemarin saya gabut", "Jadi saya merubah rencana, menegerjakan di kamopus", "Charger saya ketinggalan" ));
//        dailyReportList.add(new DummyDailyReport("Samantha","Kemarin saya gabut", "Jadi saya merubah rencana, menegerjakan di kamopus", "Charger saya ketinggalan" ));
//        dailyReportList.add(new DummyDailyReport("Elsa","Kemarin saya gabut", "Jadi saya merubah rencana, menegerjakan di kamopus", "Charger saya ketinggalan" ));
//        dailyReportList.add(new DummyDailyReport("Anna","Kemarin saya gabut", "Jadi saya merubah rencana, menegerjakan di kamopus", "Charger saya ketinggalan" ));
//
//    }
}