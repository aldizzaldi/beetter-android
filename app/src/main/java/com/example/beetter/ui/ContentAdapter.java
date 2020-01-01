package com.example.beetter.ui;

import java.util.List;

public class ContentAdapter {
    private final List item;
    private final OnItemClickListener listener;

    public ContentAdapter(List item, OnItemClickListener listener){
        this.item = item;
        this.listener = listener;
    }
}
