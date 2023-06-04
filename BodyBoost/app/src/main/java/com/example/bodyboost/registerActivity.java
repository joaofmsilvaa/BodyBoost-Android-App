package com.example.bodyboost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText goal;
    private EditText height;
    private EditText weight;

    private TextView logInTextView;

    private Button registerButton;

    private String usernameString;
    private String passwordString;
    private String goalString;
    private String heightString;
    private String weightString;

    private List<Integer> daysOfWeek = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        goal = findViewById(R.id.goalEditText);
        height = findViewById(R.id.heightEditText);
        weight = findViewById(R.id.weightEditText);

        registerButton = findViewById(R.id.registerBtn);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp(view);
            }
        });

        logInTextView = findViewById(R.id.signIN);

        logInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInMenu(view);
            }
        });
    }

    public void signInMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void signUp(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        UserDao userDao = db.getUserDao();
        UserPlanDao userPlanDao = db.getUserPlanDao();

        usernameString = username.getText().toString();
        passwordString = password.getText().toString();
        goalString = goal.getText().toString();
        heightString = height.getText().toString();
        weightString = weight.getText().toString();

        float weightFloat = Float.parseFloat(weightString);
        float heightFloat = Float.parseFloat(heightString);
        
        int usernameAvailable = userDao.isUsernameAvailable(usernameString);

        if (usernameAvailable > 0) {
            // Username is already taken
            Toast.makeText(this, "Username is not available", Toast.LENGTH_SHORT).show();
        } else{
            User user = new User(0, usernameString, passwordString, weightFloat, heightFloat, goalString);
            userDao.insert(user);

            int planValue = goalString.equals("lose weight") ? 1 : 2;
            UserPlan userPlan = new UserPlan(0, planValue);
            userPlanDao.insert(userPlan);

            // Insert values into userCompleted table for all exercises and days
            UserCompletedDao userCompletedDao = db.getUserCompletedDao();
            int userId = userDao.getUserId(usernameString);

            List<Integer> exerciseIds = retrieveExerciseIdsFromDatabase(planValue); // Retrieve exercise IDs from the "exercises" table

            for (int exerciseId : exerciseIds) {
                for (int day : daysOfWeek) {
                    UserCompleted userCompleted = new UserCompleted(0, day, exerciseId, userId, false);
                    userCompletedDao.insert(userCompleted);
                }
            }

            // Redirect to homeActivity
            Intent intent = new Intent(this, homeActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
            finish();
        }
    }

    private List<Integer> retrieveExerciseIdsFromDatabase(int planId) {
        AppDatabase db = AppDatabase.getInstance(this);
        WorkoutPlanDao workoutPlanDao = db.getWorkoutPlanDao();


        List<Integer> exerciseIds = workoutPlanDao.getAllExerciseIds(planId);

        return exerciseIds;
    }

}