package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.models.databaseModels.WorkoutPlanDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WorkoutRepository {
    private WorkoutPlanDao workoutPlanDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public WorkoutRepository(Context context) {
        this.workoutPlanDao = AppDatabase.getInstance(context).getWorkoutPlanDao();
    }

    public List<Exercise> getExercises(int userId, int dayId) {
        return this.workoutPlanDao.getExercises(userId, dayId);
    }

}



