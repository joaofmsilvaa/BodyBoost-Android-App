package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DaysRepository {
    private DaysDao daysDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public DaysRepository(Context context) {
        this.daysDao = AppDatabase.getInstance(context).getDaysDao();
    }

    public String getById(int dayId) {
        return this.daysDao.getDayByID(dayId);
    }

    public List<Days> getAll(){
        return this.daysDao.getAll();
    }

    public List<Days> getCurrentDay(int id){
        return this.daysDao.getCurrentDay(id);
    }

}



