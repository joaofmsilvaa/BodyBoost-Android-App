package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.models.databaseModels.UserDao;
import com.example.bodyboost.models.databaseModels.UserPlanDao;
import com.example.bodyboost.models.databaseModels.WorkoutPlanDao;
import com.example.bodyboost.models.retrofit.JsonPlaceHolderService;
import com.example.bodyboost.models.retrofit.RetrofitClient;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserDao userDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    private JsonPlaceHolderService service;

    public UserRepository(Context context) {
        this.userDao = AppDatabase.getInstance(context).getUserDao();
        this.service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);
    }

    public int getUserId(String username){
        return userDao.getUserId(username);
    }

    public int correspondingUsers(String username, String password){
        return userDao.correspondingUsers(username, password);
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public int isUsernameAvailable(String username){
        return userDao.isUsernameAvailable(username);
    }

    public String userGoal(int id){
        return userDao.userGoal(id);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void insert(User user){
        userDao.insert(user);
    }


}




