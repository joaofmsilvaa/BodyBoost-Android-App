package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Feed {

    @PrimaryKey
    int feedId;

    String newsTitle;
    String newsText;
    String newsImg;

    public Feed(int feedId, String newsTitle, String newsText, String newsImg) {
        this.feedId = feedId;
        this.newsTitle = newsTitle;
        this.newsText = newsText;
        this.newsImg = newsImg;
    }

    public int getFeedId() {
        return feedId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsText() {
        return newsText;
    }

    public String getNewsImg() {
        return newsImg;
    }
}
