package com.example.bodyboost.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.NewsRepository;

import java.util.List;
public class NewsViewModel extends AndroidViewModel {
    private NewsRepository repository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new NewsRepository(application.getApplicationContext());
    }

    public LiveData<List<Feed>> getNews() {
        return repository.getNews();
    }

    public Feed getById(int newsId) {
        return repository.getById(newsId);
    }
}



