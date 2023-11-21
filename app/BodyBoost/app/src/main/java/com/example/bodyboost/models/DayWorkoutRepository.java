package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DayWorkoutDao;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.models.databaseModels.UserPlanDao;
import com.example.bodyboost.models.databaseModels.WorkoutPlanDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DayWorkoutRepository {
    private DayWorkoutDao dayWorkoutDao;

    public DayWorkoutRepository(Context context) {
        this.dayWorkoutDao = AppDatabase.getInstance(context).getDayWorkoutDao();
    }

    public String getDescriptionByDayPlan(int dayId, int planId) {
        return this.dayWorkoutDao.getDescriptionByDayPlan(dayId, planId);
    }

}




