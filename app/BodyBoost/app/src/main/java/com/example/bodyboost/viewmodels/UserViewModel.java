package com.example.bodyboost.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

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
        // Initialize repository
        this.repository = new UserRepository(application.getApplicationContext());
    }

    public int getUserId(String username){
        return repository.getUserId(username);
    }

    public int correspondingUsers(String username, String password){
        return repository.correspondingUsers(username, password);
    }

    public User getUserById(int id){
        return repository.getUserById(id);
    }

    public int isUsernameAvailable(String username){
        return repository.isUsernameAvailable(username);
    }

    public String userGoal(int id){
        return repository.userGoal(id);
    }

    public void updateUser(User user){
        repository.updateUser(user);
    }

    public void insert(User user){
        repository.insert(user);
    }


    public void createUser(Callback<UserResponse> requestFailed) {
    }

    public void storeUser(User user){
        repository.insert(user);
    }
}








