package com.example.bodyboost.models.retrofit;

import android.database.Observable;

import com.example.bodyboost.models.IngredientsResponse;
import com.example.bodyboost.models.MealIngredientsResponse;
import com.example.bodyboost.models.MealResponse;
import com.example.bodyboost.models.NewsResponse;
import com.example.bodyboost.models.User;
import com.example.bodyboost.models.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
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

    @POST("appUser/store")
    Call<UserResponse> registerUser(@Body User user);

    @GET("appUser/show/{username}/{password}")
    Call<UserResponse> getUserByUsernameAndPassword(@Path("username") String username, @Path("password") String password);

}


