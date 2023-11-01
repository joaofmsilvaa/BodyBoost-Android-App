package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.MealIngredientsRepository;
import com.example.bodyboost.models.WorkoutRepository;

import java.util.List;

public class MealIngredientsViewModel extends AndroidViewModel {
    private MealIngredientsRepository repository;

    public MealIngredientsViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new MealIngredientsRepository(application.getApplicationContext());
    }

    public String getQuantityById(int ingredientsId) {
        return repository.getQuantityById(ingredientsId);
    }
}







