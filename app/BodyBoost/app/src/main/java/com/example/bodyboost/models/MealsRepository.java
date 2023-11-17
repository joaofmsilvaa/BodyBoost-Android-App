package com.example.bodyboost.models;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.IngredientsDao;
import com.example.bodyboost.models.databaseModels.MealIngredientsDao;
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
    private MealIngredientsDao mealIngredientsDao;
    private IngredientsDao ingredientsDao;
    private JsonPlaceHolderService service;
    private Executor executor = Executors.newSingleThreadExecutor();

    public MealsRepository(Context context) {
        // Initialize the DAO
        this.mealsDao = AppDatabase.getInstance(context).getMealsDao();
        this.mealIngredientsDao = AppDatabase.getInstance(context).getMealIngredientsDao();
        this.ingredientsDao = AppDatabase.getInstance(context).getIngredientsDao();
        this.service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);
    }

    public void fetchMeals(Context context){
        Call<MealResponse> call = service.getMeals();
        call.enqueue(new Callback<MealResponse>() {
        @Override
        public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
            if (response.isSuccessful()) {
                MealResponse mealResponse = response.body();
                List<Meals> mealsList = mealResponse.getData();

                insertMeals(mealsList);

                for (Meals meal : mealsList) {
                    getIngredientsForMeal(meal, context);
                }

                for(Meals meal : mealsList){
                    getMealIngredientsForMeal(meal, context);
                }

            } else {
                Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<MealResponse> call, Throwable t) {
            Toast.makeText(context, t + "", Toast.LENGTH_SHORT).show();
        }
    });
    }

    public LiveData<List<Meals>> getMeals(){
        return mealsDao.getAll();
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

    private void getIngredientsForMeal(Meals meal, Context context) {
        JsonPlaceHolderService service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);

        Call<IngredientsResponse> call = service.getIngredientsForMeal(meal.getMealId());
        call.enqueue(new Callback<IngredientsResponse>() {
            @Override
            public void onResponse(Call<IngredientsResponse> call, Response<IngredientsResponse> response) {
                if (response.isSuccessful()) {
                    IngredientsResponse ingredientResponse = response.body();
                    List<Ingredients> ingredients = ingredientResponse.getData();

                    onIngredientsReceived(ingredients);
                } else {
                    Toast.makeText(context, "Request Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IngredientsResponse> call, Throwable t) {
                Toast.makeText(context, t + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void onIngredientsReceived(List<Ingredients> ingredients) {
        executor.execute(() -> {
            for (Ingredients ingredient : ingredients) {
                Ingredients existingIngred = ingredientsDao.getById(ingredient.getIngredientsId());
                if (existingIngred == null) {
                    ingredientsDao.insert(ingredient);
                } else {
                    ingredientsDao.deleteIngred(ingredient);
                    ingredientsDao.insert(ingredient);
                }
            }
        });

    }
    private void onMealIngredientsReceived(List<MealIngredients> mealIngredients) {
        executor.execute(() -> {
            for (MealIngredients ingredient : mealIngredients) {
                MealIngredients existingMealIngred = mealIngredientsDao.getById(ingredient.getId());
                if (existingMealIngred == null) {
                    mealIngredientsDao.insert(ingredient);
                } else {
                    mealIngredientsDao.delete(existingMealIngred);
                    mealIngredientsDao.insert(ingredient);
                }
            }
        });

    }
    private void getMealIngredientsForMeal(Meals meal, Context context) {
        JsonPlaceHolderService service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);

        Call<MealIngredientsResponse> call = service.getMealIngredientsForMeal(meal.getMealId());
        call.enqueue(new Callback<MealIngredientsResponse>() {
            @Override
            public void onResponse(Call<MealIngredientsResponse> call, Response<MealIngredientsResponse> response) {
                if (response.isSuccessful()) {
                    MealIngredientsResponse mealIngredientsResponse = response.body();
                    List<MealIngredients> mealIngredients = mealIngredientsResponse.getData();

                    onMealIngredientsReceived(mealIngredients);
                } else {
                    Toast.makeText(context, "Request Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MealIngredientsResponse> call, Throwable t) {
                Toast.makeText(context, t + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


