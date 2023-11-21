package com.example.bodyboost.models;

import android.content.Context;
import android.widget.Toast;

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
import retrofit2.Response;

public class NewsRepository {
    private FeedDao newsDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks
    private JsonPlaceHolderService service;

    public NewsRepository(Context context) {
        // Initialize the DAO
        this.newsDao = AppDatabase.getInstance(context).getFeedDao();
        this.service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);
    }

    public void fetchNews(Context context) {
        // Call getNews method from the service
        Call<NewsResponse> call = service.getNews();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    // Convert the news response to a list of news ( Feed )
                    NewsResponse mealResponse = response.body();
                    List<Feed> mealsList = mealResponse.getData();

                    insertNews(mealsList);

                } else {
                    Toast.makeText(context, "Request Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(context, t + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public LiveData<List<Feed>> getNews() {
        return this.newsDao.getAll();
    }

    public Feed getById(int newsId){
        return this.newsDao.getById(newsId);
    }

    // Method to insert the news in the database if they don't exist yet
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



