package com.example.bodyboost.models.databaseModels;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.Meals;

import java.util.List;

@Dao
public interface FeedDao {

    @Query("SELECT * FROM feed")
    LiveData<List<Feed>> getAll();

    @Query("SELECT * FROM feed WHERE feedId = :id")
    Feed getById(int id);

}
