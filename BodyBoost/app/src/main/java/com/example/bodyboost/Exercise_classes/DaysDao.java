package com.example.bodyboost.Exercise_classes;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.Exercise_classes.Days;

import java.util.List;

@Dao
public interface DaysDao {

    @Query("SELECT * FROM days")
    List<Days> getAll();

}
