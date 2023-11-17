package com.example.bodyboost.models;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.models.databaseModels.UserDao;
import com.example.bodyboost.models.databaseModels.UserPlanDao;
import com.example.bodyboost.models.databaseModels.WorkoutPlanDao;
import com.example.bodyboost.models.retrofit.JsonPlaceHolderService;
import com.example.bodyboost.models.retrofit.RetrofitClient;
import com.example.bodyboost.views.homeActivity;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserDao userDao;
    private UserPlanDao userPlanDao;
    private WorkoutPlanDao workoutPlanDao;
    private UserCompletedDao userCompletedDao;
    private JsonPlaceHolderService service;
    int userId;

    public int getUserId() {
        return userId;
    }

    public UserRepository(Context context) {
        this.userDao = AppDatabase.getInstance(context).getUserDao();
        this.userPlanDao = AppDatabase.getInstance(context).getUserPlanDao();
        this.workoutPlanDao = AppDatabase.getInstance(context).getWorkoutPlanDao();
        this.userCompletedDao = AppDatabase.getInstance(context).getUserCompletedDao();
        this.service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);

    }

    public int getUserId(String username){
        return userDao.getUserId(username);
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public int isUsernameAvailable(String username){
        return userDao.isUsernameAvailable(username);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void insert(User user){
        userDao.insert(user);
    }

    public void registerUser(Context context, User user, List<Integer> daysOfWeek){
        Call<UserResponse> postCall = service.registerUser(user);
        postCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    User createdUser = userResponse.getData();

                    userId = userResponse.getUserId();

                    setUserId(userId);

                    userDao.insert(createdUser);

                    int planValue = createdUser.getObjective().equals("lose weight") ? 1 : 2;

                    UserPlan userPlan = new UserPlan(createdUser.getUserId(), planValue);

                    userPlanDao.insert(userPlan);

                    for (int i = 0; i < daysOfWeek.size(); i++) {
                        List<Integer> getExercisesInDay = workoutPlanDao.getExercisesInDay(planValue, i);

                        for (int exerciseId : getExercisesInDay) {
                            UserCompleted userCompleted = new UserCompleted(0, createdUser.getUserId(), i, exerciseId, false);

                            userCompletedDao.insert(userCompleted);
                        }
                    }

                    Intent intent = new Intent(context, homeActivity.class);
                    intent.putExtra("userId", createdUser.userId);
                    startActivity(context,intent, null);


                } else {
                    Toast.makeText(context,"Response not successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loginUser(Context context, String username, String hashedpassowrd, List<Integer> daysOfWeek){
        Call<UserResponse> call = service.getUserByUsernameAndPassword(username, hashedpassowrd);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    User user = userResponse.getData();

                    int ammountOfUserWithName = userDao.getUserId(user.username);

                    if(ammountOfUserWithName > 0){

                        setUserId(userId);

                        Intent intent = new Intent(context, homeActivity.class);
                        intent.putExtra("userId", user.userId);
                        startActivity(context,intent, null);

                    }
                    else{
                        userDao.insert(user);

                        int planValue = user.getObjective().equals("lose weight") ? 1 : 2;

                        UserPlan userPlan = new UserPlan(user.userId, planValue);

                        userPlanDao.insert(userPlan);

                        for (int i = 0; i < daysOfWeek.size(); i++) {
                            List<Integer> getExercisesInDay = workoutPlanDao.getExercisesInDay(planValue, i);

                            for (int exerciseId : getExercisesInDay) {
                                UserCompleted userCompleted = new UserCompleted(0, user.getUserId(), i, exerciseId, false);

                                userCompletedDao.insert(userCompleted);
                            }
                        }

                        Intent intent = new Intent(context, homeActivity.class);
                        intent.putExtra("userId", user.userId);
                        startActivity(context,intent, null);

                    }

                } else {
                    Toast.makeText(context, "The given credentials do not match any user in the database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context, t + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateUserApi(User user, Context context, String updatedGoal){
        Call<UserResponse> postCall = service.updateUser(user.userId,user);
        postCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    User updatedUser = userResponse.getData();

                    setUserId(updatedUser.userId);
                    userDao.updateUser(updatedUser);

                    userCompletedDao.deleteByUserId(userId);
                    userPlanDao.deletePlanByUserId(userId);

                    int planValue = updatedGoal.equalsIgnoreCase("lose weight") ? 1 : 2;

                    UserPlan userPlan = new UserPlan(userId, planValue);
                    userPlanDao.insert(userPlan);

                    List<Integer> daysOfWeek = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
                    for (int day : daysOfWeek) {
                        List<Integer> exerciseIds = workoutPlanDao.getExercisesInDay(planValue, day);
                        for (int exerciseId : exerciseIds) {
                            UserCompleted userCompleted = new UserCompleted(0, userId, day, exerciseId, false);
                            userCompletedDao.insert(userCompleted);
                        }
                    }

                    Toast.makeText(context, "Changes saved", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(context,response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context,t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int userId(){
        return this.userId;
    }
    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }


}




