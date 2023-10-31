package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.FeedDao;
import com.example.bodyboost.models.databaseModels.MealsDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NewsRepository {
    private FeedDao newsDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public NewsRepository(Context context) {
        // Initialize the DAO
        this.newsDao = AppDatabase.getInstance(context).getFeedDao();
    }

    // Doesn't require executor since we're observing the list in our Activity
    public LiveData<List<Feed>> getNews() {
        return this.newsDao.getAll();
    }

    public Feed getById(int newsId){
        return this.newsDao.getById(newsId);
    }

}



