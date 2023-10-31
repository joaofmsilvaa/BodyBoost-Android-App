package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.bodyboost.models.ExerciseSet;
import com.example.bodyboost.models.ExerciseSetRepository;

public class ExerciseSetViewModel extends AndroidViewModel {
    private ExerciseSetRepository repository;

    public ExerciseSetViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new ExerciseSetRepository(application.getApplicationContext());
    }

    public ExerciseSet getInfosForExercise(int exerciseId) {
        return repository.getInfosForExercise(exerciseId);
    }
}






