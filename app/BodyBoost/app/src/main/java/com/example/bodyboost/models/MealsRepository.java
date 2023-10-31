package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.MealsDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MealsRepository {
    private MealsDao mealsDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public MealsRepository(Context context) {
        // Initialize the DAO
        this.mealsDao = AppDatabase.getInstance(context).getMealsDao();
    }

    // Doesn't require executor since we're observing the list in our Activity
    public LiveData<List<Meals>> getMeals() {
        return this.mealsDao.getAll();
    }

    public Meals getById(int mealId){
        return this.mealsDao.getById(mealId);
    }

}


