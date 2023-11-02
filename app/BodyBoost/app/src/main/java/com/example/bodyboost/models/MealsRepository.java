package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.retrofit.JsonPlaceHolderService;
import com.example.bodyboost.models.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealsRepository {
    private MealsDao mealsDao;
    private List<Meals> mealsList = new ArrayList<>();
    private JsonPlaceHolderService service;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public MealsRepository(Context context) {
        // Initialize the DAO
        this.mealsDao = AppDatabase.getInstance(context).getMealsDao();
        this.service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);
    }

    public void getMeals(Callback<MealResponse> callback) {
        Call<MealResponse> call = service.getMeals();
        call.enqueue(callback);

    }

    public void insertMeals(List<Meals> meals) {
        executor.execute(() -> {
            for (Meals meal : meals) {
                Meals existingMeal = mealsDao.getById(meal.getMealId());
                if (existingMeal == null) {
                    mealsDao.insertMeals(meal);
                } else {
                    mealsDao.deleteMeal(existingMeal);
                    mealsDao.insertMeals(meal);
                }
            }
        });
    }

    public Meals getById(int mealId){
        return this.mealsDao.getById(mealId);
    }

}


