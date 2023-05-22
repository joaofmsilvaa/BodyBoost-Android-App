package com.example.bodyboost.Feed_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Feed {

    @PrimaryKey(autoGenerate = true)
    int feedId;
    String newsTitle;
    String newsSmallDescription;
    String newsImg;

    public Feed(int feedId, String newsTitle, String newsSmallDescription, String newsImg) {
        this.feedId = feedId;
        this.newsTitle = newsTitle;
        this.newsSmallDescription = newsSmallDescription;
        this.newsImg = newsImg;
    }

    public int getFeedId() {
        return feedId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsSmallDescription() {
        return newsSmallDescription;
    }

    public String getNewsImg() {
        return newsImg;
    }
}
