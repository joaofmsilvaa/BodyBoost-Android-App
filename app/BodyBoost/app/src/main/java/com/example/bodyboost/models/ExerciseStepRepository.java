package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.models.databaseModels.ExerciseSetDao;
import com.example.bodyboost.models.databaseModels.ExerciseStepsDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.models.databaseModels.WorkoutPlanDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExerciseStepRepository {
    private ExerciseStepsDao exerciseStepsDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public ExerciseStepRepository(Context context) {
        this.exerciseStepsDao = AppDatabase.getInstance(context).getExerciseStepsDao();
    }

    public List<String> getExerciseSteps(int exerciseId) {
        return this.exerciseStepsDao.getExerciseSteps(exerciseId);
    }

}




