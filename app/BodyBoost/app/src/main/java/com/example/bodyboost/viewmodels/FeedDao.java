package com.example.bodyboost.viewmodels;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.models.Feed;

import java.util.List;

@Dao
public interface FeedDao {

    @Query("SELECT * FROM feed")
    List<Feed> getAll();


    @Query("SELECT newsTitle FROM feed WHERE feedId = :newsId")
    String getNewsTitleById(int newsId);

    @Query("SELECT newsSmallDescription FROM feed WHERE feedId = :newsId")
    String getNewsSmallDesById(int newsId);

    @Query("SELECT newsFullDescription FROM feed WHERE feedId = :newsId")
    String getFullDesById(int newsId);

    @Query("SELECT newsImg FROM feed WHERE feedId = :newsId")
    String getNewsImgById(int newsId);

    @Query("SELECT newsDate FROM feed WHERE feedId = :newsId")
    String getNewsDateById(int newsId);

    @Query("SELECT sourceWebsite FROM feed WHERE feedId = :newsId")
    String getWebsiteById(int newsId);

    @Query("SELECT sourceLink FROM feed WHERE feedId = :newsId")
    String getSourceLinkById(int newsId);

}
