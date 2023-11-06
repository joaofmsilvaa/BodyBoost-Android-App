package com.example.bodyboost.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.MealResponse;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.NewsRepository;
import com.example.bodyboost.models.NewsResponse;

import java.util.List;

import retrofit2.Callback;

public class NewsViewModel extends AndroidViewModel {
    private NewsRepository repository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new NewsRepository(application.getApplicationContext());
    }

    public void fetchNews(Callback<NewsResponse> callback) {
        repository.fetchNews(callback);
    }

    public LiveData<List<Feed>> getNews() {
        return repository.getNews();
    }

    public Feed getById(int newsId) {
        return repository.getById(newsId);
    }

    public void insertNews(List<Feed> newsList){
        repository.insertNews(newsList);
    }
}



