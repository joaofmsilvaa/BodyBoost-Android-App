package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserCompletedRepository {
    private UserCompletedDao userCompletedDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public UserCompletedRepository(Context context) {
        this.userCompletedDao = AppDatabase.getInstance(context).getUserCompletedDao();
    }

    public List<Exercise> getExercisesForUser(int userId, int dayId, int planId) {
        return this.userCompletedDao.getExercisesForUser(userId, dayId, planId);
    }

    public int checkIfExerciseCompleted(int userId, int dayId, int planId) {
        return this.userCompletedDao.checkIfExerciseCompleted(userId, dayId, planId);
    }

    public void updateExerciseCompleted(int value, int dayId, int userId, int exerciseId){
        this.userCompletedDao.updateExerciseCompleted(value,dayId,userId,exerciseId);
    }

}


