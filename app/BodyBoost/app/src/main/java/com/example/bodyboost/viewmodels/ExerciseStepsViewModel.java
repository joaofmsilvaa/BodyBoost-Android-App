package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.bodyboost.models.ExerciseSet;
import com.example.bodyboost.models.ExerciseSetRepository;
import com.example.bodyboost.models.ExerciseStepRepository;

import java.util.List;

public class ExerciseStepsViewModel extends AndroidViewModel {
    private ExerciseStepRepository repository;

    public ExerciseStepsViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new ExerciseStepRepository(application.getApplicationContext());
    }

    public List<String> getExerciseSteps(int exerciseId) {
        return repository.getExerciseSteps(exerciseId);
    }
}







