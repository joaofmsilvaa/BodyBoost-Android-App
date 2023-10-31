package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.bodyboost.models.DaysRepository;

public class DaysViewModel extends AndroidViewModel {
    private DaysRepository repository;

    public DaysViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new DaysRepository(application.getApplicationContext());
    }

    public String getDayByID(int dayId) {
        return repository.getById(dayId);
    }
}





