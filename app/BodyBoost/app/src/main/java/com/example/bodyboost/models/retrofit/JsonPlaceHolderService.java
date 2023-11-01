package com.example.bodyboost.models.retrofit;

import com.example.bodyboost.models.MealResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderService {

    @GET("meals/")
    Call<MealResponse> getMeals();
}


