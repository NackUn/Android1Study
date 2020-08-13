package com.example.android1study;

import com.google.gson.annotations.SerializedName;

public class MovieEntity {
    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}