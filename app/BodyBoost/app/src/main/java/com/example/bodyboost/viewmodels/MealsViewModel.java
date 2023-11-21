package com.example.bodyboost.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.MealResponse;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.MealsRepository;

import java.util.List;

import retrofit2.Callback;

public class MealsViewModel extends AndroidViewModel {
    private MealsRepository repository;

    public MealsViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new MealsRepository(application.getApplicationContext());
    }

    public void fetchMeals(Context context) {
        repository.fetchMeals(context);
    }

    public LiveData<List<Meals>> getMeals() {
        return repository.getMeals();
    }

    public Meals getById(int mealId) {
        return repository.getById(mealId);
    }
}


