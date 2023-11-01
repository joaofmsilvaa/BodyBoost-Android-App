package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.models.databaseModels.MealIngredientsDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.models.databaseModels.WorkoutPlanDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MealIngredientsRepository {
    private MealIngredientsDao mealIngredientsDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public MealIngredientsRepository(Context context) {
        this.mealIngredientsDao = AppDatabase.getInstance(context).getMealIngredientsDao();
    }

    public String getQuantityById(int ingredientId) {
        return this.mealIngredientsDao.getQuantityById(ingredientId);
    }

}




