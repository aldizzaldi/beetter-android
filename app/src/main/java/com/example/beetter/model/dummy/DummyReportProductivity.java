package com.example.beetter.model.dummy;

import android.widget.ImageView;

public class DummyReportProductivity {
    private String name;
    private String timeConsume;
    private ImageView application;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeConsume() {
        return timeConsume;
    }

    public void setTimeConsume(String timeConsume) {
        this.timeConsume = timeConsume;
    }

    public ImageView getApplication() {
        return application;
    }

    public void setApplication(ImageView application) {
        this.application = application;
    }
}
