package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.WorkoutRepository;

import java.util.List;

public class WorkoutViewModel extends AndroidViewModel {
    private WorkoutRepository repository;

    public WorkoutViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new WorkoutRepository(application.getApplicationContext());
    }

    public List<Exercise> getExercises(int userId, int dayId) {
        return repository.getExercises(userId, dayId);
    }
}






