package com.example.beetter.model.dummy;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DummyReportProductivityLuar {
    private String nama;
    private RecyclerView recyclerView;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public DummyReportProductivityLuar(String nama, RecyclerView recyclerView) {
        this.nama = nama;
        this.recyclerView = recyclerView;
    }

    public DummyReportProductivityLuar(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
