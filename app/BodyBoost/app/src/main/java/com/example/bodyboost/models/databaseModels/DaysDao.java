package com.example.bodyboost.models.databaseModels;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodyboost.models.Days;

import java.util.List;

@Dao
public interface DaysDao {

    @Query("SELECT * FROM days")
    List<Days> getAll();

    @Query("SELECT day FROM days WHERE dayId = :id")
    String getDayByID(int id);


    @Query("SELECT * FROM days WHERE dayId = :id")
    List<Days> getCurrentDay(int id);

    @Insert
    void insertAll(Days day);


}
