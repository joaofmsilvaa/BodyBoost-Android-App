package com.example.bodyboost.models;

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
    public String newsDate;

    public String sourceWebsite;
    public String sourceLink;

    public Feed(int feedId, String newsTitle, String newsSmallDescription, String newsFullDescription,String newsImg, String newsDate, String sourceWebsite, String sourceLink) {
        this.feedId = feedId;
        this.newsTitle = newsTitle;
        this.newsSmallDescription = newsSmallDescription;
        this.newsFullDescription = newsFullDescription;
        this.newsImg = newsImg;
        this.newsDate = newsDate;
        this.sourceWebsite = sourceWebsite;
        this.sourceLink = sourceLink;
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
