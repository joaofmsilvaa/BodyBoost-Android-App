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
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderService {

    @GET("meals/")
    Call<MealResponse> getMeals();

    @GET("meals/{id}/ingredients")
    Call<IngredientsResponse> getIngredientsForMeal(@Path("id") int mealId);

    @GET("meals/{id}/meal-ingredients")
    Call<MealIngredientsResponse> getMealIngredientsForMeal(@Path("id") int mealId);

    @GET("news/")
    Call<NewsResponse> getNews();

    @GET("appUser/show")
    Call<UserResponse> getUserByUsernameAndPassword(@Query("username") String username, @Query("password") String password);

    @POST("appUser/store")
    Call<UserResponse> registerUser(@Body User user);

    @PUT("appUser/update/{id}'")
    Call<UserResponse> updateUser(@Path("id") int id, @Body User user);

}


