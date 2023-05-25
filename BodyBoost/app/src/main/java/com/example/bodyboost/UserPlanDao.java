package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserPlanDao {

    @Query("SELECT * FROM UserPlan")
    List<UserPlan> getAll();

}
