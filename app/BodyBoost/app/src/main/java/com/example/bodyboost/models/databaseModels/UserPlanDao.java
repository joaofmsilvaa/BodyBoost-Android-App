package com.example.bodyboost.models.databaseModels;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodyboost.models.UserPlan;

import java.util.List;

@Dao
public interface UserPlanDao {

    @Query("SELECT * FROM UserPlan")
    List<UserPlan> getAll();

    @Query("SELECT planId FROM userplan WHERE userId = :id LIMIT 1")
    int getUserPlanById(int id);

    @Insert
    void insert(UserPlan userPlan);

    @Query("DELETE FROM userplan WHERE userId = :id")
    void deletePlanByUserId(int id);

}
