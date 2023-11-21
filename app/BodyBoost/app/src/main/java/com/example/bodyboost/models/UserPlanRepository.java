package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.models.databaseModels.UserPlanDao;
import com.example.bodyboost.models.databaseModels.WorkoutPlanDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserPlanRepository {
    private UserPlanDao userPlanDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public UserPlanRepository(Context context) {
        this.userPlanDao = AppDatabase.getInstance(context).getUserPlanDao();
    }

    public int getUserPlanById(int userId) {
        return this.userPlanDao.getUserPlanById(userId);
    }


    public void insert(UserPlan userPlan){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                userPlanDao.insert(userPlan);
            }
        });
    }

}



