package com.example.bodyboost.Exercise_classes;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaysDao {

    @Query("SELECT * FROM days")
    List<Days> getAll();

    @Query("SELECT day FROM days WHERE dayId = :id")
    String getDayByID(int id);


    @Insert
    void insertAll(Days day);


}
