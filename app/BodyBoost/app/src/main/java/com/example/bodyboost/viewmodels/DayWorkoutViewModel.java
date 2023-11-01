package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.bodyboost.models.DayWorkoutRepository;
import com.example.bodyboost.models.DaysRepository;

public class DayWorkoutViewModel extends AndroidViewModel {
    private DayWorkoutRepository repository;

    public DayWorkoutViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new DayWorkoutRepository(application.getApplicationContext());
    }

    public String getDescriptionByDayPlan(int dayId, int planId) {
        return repository.getDescriptionByDayPlan(dayId, planId);
    }
}






