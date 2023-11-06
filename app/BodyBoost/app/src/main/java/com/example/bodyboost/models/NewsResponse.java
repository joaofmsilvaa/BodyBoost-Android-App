package com.example.bodyboost.models;

import java.util.List;

public class NewsResponse {

    List<Feed> data;

    public NewsResponse(List<Feed> data) {
        this.data = data;
    }

    public List<Feed> getData() {
        return data;
    }

}

