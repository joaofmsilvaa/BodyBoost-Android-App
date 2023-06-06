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

    private AppDatabase db;
    private UserDao userDao;
    private UserPlanDao userPlanDao;
    private UserCompletedDao userCompletedDao;
    private WorkoutPlanDao workoutPlanDao;


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

    private List<Integer> daysOfWeek = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = AppDatabase.getInstance(this);
        userDao = db.getUserDao();
        userPlanDao = db.getUserPlanDao();
        userCompletedDao = db.getUserCompletedDao();
        workoutPlanDao = db.getWorkoutPlanDao();

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
        } else {
            User user = new User(0, usernameString, passwordString, weightFloat, heightFloat, goalString);
            userDao.insert(user);

            int userId = userDao.getUserId(usernameString);

            int planValue = goalString.equals("lose weight") ? 1 : 2;

            UserPlan userPlan = new UserPlan(userId, planValue);
            
            userPlanDao.insert(userPlan);

            for (int i = 0; i < daysOfWeek.size(); i++) {
                List<Integer> getExercisesInDay = workoutPlanDao.getExercisesInDay(planValue, i);

                for (int exerciseId : getExercisesInDay) {
                    UserCompleted userCompleted = new UserCompleted(0, userId, i, exerciseId, false);

                    userCompletedDao.insert(userCompleted);
                }
            }

            Intent intent = new Intent(this, homeActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
            finish();
        }
    }

}