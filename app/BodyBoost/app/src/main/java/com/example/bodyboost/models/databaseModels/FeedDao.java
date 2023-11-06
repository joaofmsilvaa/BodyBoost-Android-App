package com.example.bodyboost.models.databaseModels;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.Meals;

import java.util.List;

@Dao
public interface FeedDao {

    @Query("SELECT * FROM feed ORDER BY feedId DESC")
    LiveData<List<Feed>> getAll();

    @Query("SELECT * FROM feed WHERE feedId = :id")
    Feed getById(int id);

    @Insert
    void insertNews(Feed news);

    @Delete
    void deleteNews(Feed news);

}
