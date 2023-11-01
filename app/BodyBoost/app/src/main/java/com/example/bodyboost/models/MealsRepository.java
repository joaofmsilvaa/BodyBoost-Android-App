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

    // Doesn't require executor since we're observing the list in our Activity
    public List<Meals> getMeals() {

        Call<MealResponse> call = this.service.getMeals();
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful()) {
                    MealResponse mealResponse = response.body();
                    mealsList = mealResponse.getData();

                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                mealsList = new ArrayList<>();
            }
        });

        return mealsList;
    }

    public Meals getById(int mealId){
        return this.mealsDao.getById(mealId);
    }

}


