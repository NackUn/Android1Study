package com.example.android1study;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchEntity {
    @SerializedName("items")
    private List<MovieEntity> items;

    public List<MovieEntity> getItems() {
        return items;
    }

    public void setItems(List<MovieEntity> items) {
        this.items = items;
    }

}
