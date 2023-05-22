package com.example.bodyboost.Feed_classes;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FeedDao {

    @Query("SELECT * FROM feed")
    List<Feed> getAll();


}
