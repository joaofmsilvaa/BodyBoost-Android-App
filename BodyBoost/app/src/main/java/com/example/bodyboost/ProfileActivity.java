package com.example.bodyboost;

import static com.example.bodyboost.HomeFragment.userId;

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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private AppDatabase db;
    private UserDao userDao;
    private UserPlanDao userPlanDao;
    private UserCompletedDao userCompletedDao;
    private WorkoutPlanDao workoutPlanDao;
    private EditText username;
    private AutoCompleteTextView goal;
    private EditText weight;
    private EditText height;
    private Button saveChangesBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db = AppDatabase.getInstance(this);
        userDao = db.getUserDao();
        userPlanDao = db.getUserPlanDao();
        userCompletedDao = db.getUserCompletedDao();
        workoutPlanDao = db.getWorkoutPlanDao();

        username = findViewById(R.id.usernameEditText);
        goal = findViewById(R.id.goalsACT);
        weight = findViewById(R.id.weightEditText);
        height = findViewById(R.id.heightEditText);
        saveChangesBtn = findViewById(R.id.button3);

        User user = userDao.getUserById(userId);
        username.setText(user.getUsername());

        String[] goalsArray = {"Lose weight", "Gain mass"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, goalsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goal.setAdapter(adapter);
        goal.setText(user.objective, false);

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
                }
                else {
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
                startActivity(intent);
            }
        });

        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedUsername = username.getText().toString();
                String updatedGoal = goal.getText().toString();
                float updatedWeight = Float.parseFloat(weight.getText().toString());
                float updatedHeight = Float.parseFloat(height.getText().toString());

                user.setUsername(updatedUsername);
                user.setObjective(updatedGoal);
                user.setWeight(updatedWeight);
                user.setHeight(updatedHeight);

                userDao.updateUser(user);

                userCompletedDao.deleteByUserId(userId);

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

                Toast.makeText(ProfileActivity.this, "Changes saved", Toast.LENGTH_SHORT).show();
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