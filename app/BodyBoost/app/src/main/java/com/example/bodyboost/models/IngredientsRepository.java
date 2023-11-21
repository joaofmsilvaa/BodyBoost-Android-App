package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.IngredientsDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class IngredientsRepository {
    private IngredientsDao ingredientsDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public IngredientsRepository(Context context) {
        // Initialize the DAO
        this.ingredientsDao = AppDatabase.getInstance(context).getIngredientsDao();
    }

    // Doesn't require executor since we're observing the list in our Activity
    public LiveData<List<Ingredients>> getIngredientsForMeal(int mealId) {
        return this.ingredientsDao.getIngredientsById(mealId);
    }

}



