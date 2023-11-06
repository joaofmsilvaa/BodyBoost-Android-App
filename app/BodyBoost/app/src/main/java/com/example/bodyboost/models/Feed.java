package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Feed {

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    int feedId;

    @SerializedName("title")
    String newsTitle;

    @SerializedName("excerpt")
    String newsSmallDescription;

    @SerializedName("body")
    String newsFullDescription;

    @SerializedName("thumbnail")
    String newsImg;

    @SerializedName("created_at")
    public String newsDate;

    @SerializedName("source")
    public String sourceLink;

    public Feed(int feedId, String newsTitle, String newsSmallDescription, String newsFullDescription,String newsImg, String newsDate, String sourceLink) {
        this.feedId = feedId;
        this.newsTitle = newsTitle;
        this.newsSmallDescription = newsSmallDescription;
        this.newsFullDescription = newsFullDescription;
        this.newsImg = newsImg;
        this.newsDate = newsDate;
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
    public String getNewsDate(){
        return newsDate;
    }
    public String getSourceLink(){
        return sourceLink;
    }
}
