package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.Days;
import com.example.bodyboost.models.DaysRepository;

import java.util.List;

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

    public List<Days> getAll(){
        return repository.getAll();
    }
    public List<Days> getCurrentDay(int id){
        return repository.getCurrentDay(id);
    }
}





