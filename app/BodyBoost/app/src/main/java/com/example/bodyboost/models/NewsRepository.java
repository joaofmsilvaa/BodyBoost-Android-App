package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.FeedDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.retrofit.JsonPlaceHolderService;
import com.example.bodyboost.models.retrofit.RetrofitClient;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;

public class NewsRepository {
    private FeedDao newsDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks
    private JsonPlaceHolderService service;

    public NewsRepository(Context context) {
        // Initialize the DAO
        this.newsDao = AppDatabase.getInstance(context).getFeedDao();
        this.service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);
    }

    public void fetchNews(Callback<NewsResponse> callback) {
        Call<NewsResponse> call = service.getNews();
        call.enqueue(callback);
    }

    // Doesn't require executor since we're observing the list in our Activity
    public LiveData<List<Feed>> getNews() {
        return this.newsDao.getAll();
    }

    public Feed getById(int newsId){
        return this.newsDao.getById(newsId);
    }

    public void insertNews(List<Feed> newsList) {
        executor.execute(() -> {
            for (Feed news : newsList) {
                Feed existingNews = newsDao.getById(news.getFeedId());
                if (existingNews == null) {
                    newsDao.insertNews(news);
                } else {
                    newsDao.deleteNews(existingNews);
                    newsDao.insertNews(news);
                }
            }
        });
    }

}



