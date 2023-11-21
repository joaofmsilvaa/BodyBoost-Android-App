package com.example.bodyboost.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.IngredientsRepository;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.MealsRepository;
import com.example.bodyboost.models.databaseModels.IngredientsDao;

import java.util.List;

// Must extend AndroidViewModel since we will be accessing a database
public class IngredientsViewModel extends AndroidViewModel {
    private IngredientsRepository repository;

    public IngredientsViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new IngredientsRepository(application.getApplicationContext());
    }

    public LiveData<List<Ingredients>> getIngredientsForMeal(int mealId) {
        return repository.getIngredientsForMeal(mealId);
    }
}



