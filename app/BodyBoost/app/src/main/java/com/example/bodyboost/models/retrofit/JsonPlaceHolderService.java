package com.example.bodyboost.models.retrofit;

import com.example.bodyboost.models.IngredientsResponse;
import com.example.bodyboost.models.MealIngredientsResponse;
import com.example.bodyboost.models.MealResponse;
import com.example.bodyboost.models.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface JsonPlaceHolderService {

    @GET("meals/")
    Call<MealResponse> getMeals();

    @GET("meals/{id}/ingredients")
    Call<IngredientsResponse> getIngredientsForMeal(@Path("id") int mealId);

    @GET("meals/{id}/meal-ingredients")
    Call<MealIngredientsResponse> getMealIngredientsForMeal(@Path("id") int mealId);

    @GET("news/")
    Call<NewsResponse> getNews();

}


