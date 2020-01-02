package com.example.beetter.ui.reportproductivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.example.beetter.SharedPrefUtils;
import com.example.beetter.ui.profile.ProfileActivity;
import com.example.beetter.ui.splashscreen.SplashScreen;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
        ButterKnife.bind(this, root);
        btnDate.setOnClickListener(listener);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        showDate.setText(dateFormat.format(new Date()));
        presenter.getReportProductivity(showDate.getText().toString());

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.profile){
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            this.startActivity(intent);
        }
        else {
            SharedPrefUtils.removeSavedPref("id_team");
            SharedPrefUtils.removeSavedPref("token");
            Intent intent = new Intent(getActivity(), SplashScreen.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getReportProductivity(ArrayList<ReportProductivityApps> reportProductivityApps) {
        recyclerViewHorizontal = (RecyclerView) root.findViewById(R.id.recyclerViewReportProductivity);
        reportProductivityAdapter = new ReportProductivityAdapter(reportProductivityApps, getContext());
//        Log.e("Report", reportProductivityApps.size() + "!");
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
            int month = (myCalendar.get(Calendar.MONTH) + 1) % 12;
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