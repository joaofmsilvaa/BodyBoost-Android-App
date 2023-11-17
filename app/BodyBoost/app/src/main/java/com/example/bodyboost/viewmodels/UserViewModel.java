package com.example.bodyboost.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.Days;
import com.example.bodyboost.models.DaysRepository;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.User;
import com.example.bodyboost.models.UserPlan;
import com.example.bodyboost.models.UserPlanRepository;
import com.example.bodyboost.models.UserRepository;
import com.example.bodyboost.models.UserResponse;
import com.example.bodyboost.models.WorkoutRepository;

import java.util.List;

import retrofit2.Callback;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;

    public UserViewModel(@NonNull Application application) {
        super(application);

        this.repository = new UserRepository(application.getApplicationContext());
    }

    public int getUserId(String username){
        return repository.getUserId(username);
    }

    public User getUserById(int id){
        return repository.getUserById(id);
    }

    public int isUsernameAvailable(String username){
        return repository.isUsernameAvailable(username);
    }
    public void updateUser(User user){
        repository.updateUser(user);
    }

    public void updateUserAPI(User user, Context context, String updatedGoal){
        repository.updateUserApi(user, context, updatedGoal);
    }

    public void insert(User user){
        repository.insert(user);
    }

    public void storeUser(User user){
        repository.insert(user);
    }
    public void registerUser(Context context, User user, List<Integer> daysList){
        repository.registerUser(context,user, daysList);
    }

    public void loginUser(Context context, String username, String hashedpassword, List<Integer> daysOfWeek){
        repository.loginUser(context,username,hashedpassword,daysOfWeek);
    }

    public int getUserId(){
        return repository.getUserId();
    }

    public int getUserIdAPI(){
        return repository.userId();
    }

    public User getUserByName(String name){
        return repository.getUserByName(name);
    }
}








