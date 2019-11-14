package com.example.beetter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        PieChart pieChart = findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        pieChart.setTransparentCircleRadius(20f);
        pieChart.setHoleRadius(20f);

        pieChart.animateXY(1000,1000);

        List<PieEntry> value = new ArrayList<>();
        value.add(new PieEntry(60f, "productive"));
        value.add(new PieEntry(10f, "non productive"));
        value.add(new PieEntry(30f, "neutral"));

        PieDataSet pieDataSet = new PieDataSet(value,"Status");

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        //pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
    }
}
