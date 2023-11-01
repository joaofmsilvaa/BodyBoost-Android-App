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

    public int countExercisesForUser(int userId, int dayId) {
        return this.userCompletedDao.countExercisesForUser(userId, dayId);
    }

    public int ammountCompleted(int userId, int dayId) {
        return this.userCompletedDao.ammountCompleted(userId, dayId);
    }

    public int ammountOfExercisesInDay(int userId, int dayId) {
        return this.userCompletedDao.ammountOfExercisesInDay(userId, dayId);
    }

    public void deleteByUserId(int userId){
        this.userCompletedDao.deleteByUserId(userId);
    }

    public void insert(UserCompleted userCompleted){
        this.userCompletedDao.insert(userCompleted);
    }

}


