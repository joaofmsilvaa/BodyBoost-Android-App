package com.example.bodyboost.models.retrofit;

import com.example.bodyboost.models.IngredientsResponse;
import com.example.bodyboost.models.MealResponse;

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

}


