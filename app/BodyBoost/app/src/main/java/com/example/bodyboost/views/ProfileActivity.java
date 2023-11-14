package com.example.bodyboost.views;

import static com.example.bodyboost.views.HomeFragment.userId;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodyboost.models.UserResponse;
import com.example.bodyboost.R;
import com.example.bodyboost.models.User;
import com.example.bodyboost.models.UserCompleted;
import com.example.bodyboost.models.UserPlan;
import com.example.bodyboost.models.retrofit.JsonPlaceHolderService;
import com.example.bodyboost.models.retrofit.RetrofitClient;
import com.example.bodyboost.viewmodels.UserCompletedViewModel;
import com.example.bodyboost.viewmodels.UserPlanViewModel;
import com.example.bodyboost.viewmodels.UserViewModel;
import com.example.bodyboost.viewmodels.WorkoutViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private UserPlanViewModel userPlanViewModel;
    private UserCompletedViewModel userCompletedViewModel;
    private WorkoutViewModel workoutViewModel;

    private EditText username;
    private EditText password;
    private AutoCompleteTextView goal;
    private EditText weight;
    private EditText height;
    private Button saveChangesBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userPlanViewModel = new ViewModelProvider(this).get(UserPlanViewModel.class);
        userCompletedViewModel = new ViewModelProvider(this).get(UserCompletedViewModel.class);
        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);

        username = findViewById(R.id.usernameEditText);
        goal = findViewById(R.id.goalsACT);
        weight = findViewById(R.id.weightEditText);
        height = findViewById(R.id.heightEditText);
        saveChangesBtn = findViewById(R.id.button3);
        password = findViewById(R.id.passwordEditText);

        User user = userViewModel.getUserById(userId);
        username.setText(user.getappUsername());

        String[] goalsArray = {"Lose weight", "Gain mass"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, goalsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goal.setAdapter(adapter);
        goal.setText(user.getObjective(), false);

        weight.setText(Float.toString(user.getWeight()));
        height.setText(Float.toString(user.getHeight()));

        final NavigationView navigationView = findViewById(R.id.nav_view);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Hide the sidebar initially
        navigationView.setVisibility(View.GONE);

        Menu navMenu = navigationView.getMenu();
        MenuItem logOutItem = navMenu.findItem(R.id.logOut);
        MenuItem profileItem = navMenu.findItem(R.id.username);

        View headerView = navigationView.getHeaderView(0);
        Button closeButton = headerView.findViewById(R.id.close_button);

        profileItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
                return true;
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setVisibility(View.GONE);
                navigationView.setVisibility(View.GONE);
            }
        });

        logOutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                performLogout();
                return true;
            }
        });

        Button userButton = findViewById(R.id.user_button);

        userButton.setOnClickListener(new View.OnClickListener() {
            private boolean isSidebarVisible = false;

            @Override
            public void onClick(View view) {
                isSidebarVisible = !isSidebarVisible;

                if (isSidebarVisible) {
                    navigationView.setVisibility(View.VISIBLE);
                } else {
                    navigationView.setVisibility(View.GONE);
                }
            }
        });

        Button backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            private boolean isSidebarVisible = false;

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, homeActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        });

        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedUsername = username.getText().toString();

                String updatedPassword = password.getText().toString();

                if(updatedPassword.equals("")){
                    updatedPassword = user.getPassword();
                }
                String updatedGoal = goal.getText().toString();

                float updatedWeight = Float.parseFloat(weight.getText().toString());
                float updatedHeight = Float.parseFloat(height.getText().toString());

                JsonPlaceHolderService service = RetrofitClient.getClient().create(JsonPlaceHolderService.class);

                User user = new User(userId,updatedUsername,updatedPassword,updatedWeight,updatedHeight,updatedGoal);
                Call<UserResponse> postCall = service.updateUser(userId,user);
                postCall.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.isSuccessful()) {
                            UserResponse userResponse = response.body();
                            User updatedUser = userResponse.getData();
                            userViewModel.updateUser(updatedUser);

                            userCompletedViewModel.deleteByUserId(userId);
                            userPlanViewModel.deletePlanByUserId(userId);

                            int planValue = updatedGoal.equalsIgnoreCase("lose weight") ? 1 : 2;

                            UserPlan userPlan = new UserPlan(userId, planValue);
                            userPlanViewModel.insert(userPlan);

                            List<Integer> daysOfWeek = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
                            for (int day : daysOfWeek) {
                                List<Integer> exerciseIds = workoutViewModel.getExercisesInDay(planValue, day);
                                for (int exerciseId : exerciseIds) {
                                    UserCompleted userCompleted = new UserCompleted(0, userId, day, exerciseId, false);
                                    userCompletedViewModel.insert(userCompleted);
                                }
                            }

                            Toast.makeText(ProfileActivity.this, "Changes saved", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(ProfileActivity.this,response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(ProfileActivity.this,t.toString(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }

    private void performLogout() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.remove("userId");
        editor.apply();

        finishAffinity();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}