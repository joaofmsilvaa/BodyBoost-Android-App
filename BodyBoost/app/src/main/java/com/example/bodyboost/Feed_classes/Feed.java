package com.example.bodyboost.Feed_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Feed {

    @PrimaryKey(autoGenerate = true)
    int feedId;
    String newsTitle;
    String newsSmallDescription;
    String newsFullDescription;
    String newsImg;

    String newsDate;

    public Feed(int feedId, String newsTitle, String newsSmallDescription, String newsFullDescription,String newsImg, String newsDate) {
        this.feedId = feedId;
        this.newsTitle = newsTitle;
        this.newsSmallDescription = newsSmallDescription;
        this.newsFullDescription = newsFullDescription;
        this.newsImg = newsImg;
        this.newsDate = newsDate;
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
    public String getNewsFullDescription() {
        return newsFullDescription;
    }
    public String getNewsImg() {
        return newsImg;
    }
}
