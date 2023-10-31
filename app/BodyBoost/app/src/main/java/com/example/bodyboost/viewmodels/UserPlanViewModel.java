package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.DaysRepository;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.UserPlan;
import com.example.bodyboost.models.UserPlanRepository;
import com.example.bodyboost.models.WorkoutRepository;

import java.util.List;

public class UserPlanViewModel extends AndroidViewModel {
    private UserPlanRepository repository;

    public UserPlanViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new UserPlanRepository(application.getApplicationContext());
    }

    public int getUserPlanById(int userId) {
        return repository.getUserPlanById(userId);
    }
}







