package com.example.bodyboost.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.MealsRepository;

import java.util.List;

// Must extend AndroidViewModel since we will be accessing a database
public class MealsViewModel extends AndroidViewModel {
    private MealsRepository repository;

    public MealsViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new MealsRepository(application.getApplicationContext());
    }

    public List<Meals> getMeals() {
        return repository.getMeals();
    }

    public Meals getById(int mealId) {
        return repository.getById(mealId);
    }
}


