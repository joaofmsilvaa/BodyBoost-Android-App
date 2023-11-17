package com.example.bodyboost.views;


import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodyboost.R;
import com.example.bodyboost.models.MealResponse;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.User;
import com.example.bodyboost.models.UserCompleted;
import com.example.bodyboost.models.UserPlan;
import com.example.bodyboost.models.UserRepository;
import com.example.bodyboost.models.UserResponse;
import com.example.bodyboost.models.databaseModels.UserDao;
import com.example.bodyboost.models.retrofit.JsonPlaceHolderService;
import com.example.bodyboost.models.retrofit.RetrofitClient;
import com.example.bodyboost.viewmodels.Hash;
import com.example.bodyboost.viewmodels.UserCompletedViewModel;
import com.example.bodyboost.viewmodels.UserPlanViewModel;
import com.example.bodyboost.viewmodels.UserViewModel;
import com.example.bodyboost.viewmodels.WorkoutViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterActivity extends AppCompatActivity {

    private UserCompletedViewModel userCompletedViewModel;
    private WorkoutViewModel workoutViewModel;
    private UserViewModel userViewModel;
    private UserPlanViewModel userPlanViewModel;

    private EditText username;
    private EditText password;
    private EditText height;
    private EditText weight;

    private TextInputLayout textInputLayout1;
    private TextInputLayout textInputLayout2;
    private TextInputLayout textInputLayout3;
    private TextInputLayout textInputLayout4;
    private TextInputLayout textInputLayout5;

    private AutoCompleteTextView autoCompleteTextView;

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

        userCompletedViewModel = new ViewModelProvider(this).get(UserCompletedViewModel.class);
        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userPlanViewModel = new ViewModelProvider(this).get(UserPlanViewModel.class);

        autoCompleteTextView = findViewById(R.id.goalsACT);
        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        // Define the array of goals
        String[] goalsArray = {"Gain mass", "Lose weight"};

        // Create an ArrayAdapter using the goalsArray and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, goalsArray);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        autoCompleteTextView.setAdapter(adapter);


        height = findViewById(R.id.heightEditText);
        weight = findViewById(R.id.weightEditText);
        registerButton = findViewById(R.id.registerBtn);

        textInputLayout1 = findViewById(R.id.textInputLayout1);
        textInputLayout2 = findViewById(R.id.textInputLayout2);
        textInputLayout3 = findViewById(R.id.textInputLayout3);
        textInputLayout4 = findViewById(R.id.textInputLayout4);
        textInputLayout5 = findViewById(R.id.textInputLayout5);

        weight.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        height.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp(view);
            }
        });

        logInTextView = findViewById(R.id.signIN);
        logInTextView.setPaintFlags(logInTextView.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

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
        goalString = autoCompleteTextView.getText().toString();
        heightString = height.getText().toString();
        weightString = weight.getText().toString();

        int usernameAvailable = userViewModel.isUsernameAvailable(usernameString);

        if(usernameString.trim().length() > 0 && passwordString.trim().length() > 0 && goalString.trim().length() > 0 && heightString.trim().length() > 0 && weightString.trim().length() > 0) {
            if (usernameAvailable > 0) {
                // Username is already taken
                Toast.makeText(this, "Username is not available", Toast.LENGTH_SHORT).show();
            } else {
                float weightFloat = Float.parseFloat(weightString);
                float heightFloat = Float.parseFloat(heightString);

                String hashedpassword = Hash.hashPassword(passwordString);

                User user = new User(0,usernameString,hashedpassword,weightFloat,heightFloat,goalString);
                userViewModel.registerUser(RegisterActivity.this, user, daysOfWeek);

                int userId = userViewModel.getUserId();

                if(userId > 0){
                    Intent intent = new Intent(RegisterActivity.this, homeActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);
                    finish();
                }

            }
        }
        else{

            if (TextUtils.isEmpty(usernameString)) {
                textInputLayout3.setError("Insert a username");
                textInputLayout3.setErrorEnabled(true);

            } else {
                textInputLayout3.setErrorEnabled(false);
            }

            if (TextUtils.isEmpty(passwordString)) {
                textInputLayout4.setError("Insert a password");
                textInputLayout4.setErrorEnabled(true);
            } else {
                textInputLayout4.setErrorEnabled(false);
            }

            if (TextUtils.isEmpty(goalString)) {
                textInputLayout1.setError("Choose your goal");
                textInputLayout1.setErrorEnabled(true);
            } else {
                textInputLayout1.setErrorEnabled(false);
            }

            if (TextUtils.isEmpty(weightString)) {
                textInputLayout2.setError("Insert a weight");
                textInputLayout2.setErrorEnabled(true);
            } else {
                textInputLayout2.setErrorEnabled(false);
            }

            if (TextUtils.isEmpty(heightString)) {
                textInputLayout5.setError("Insert a height");
                textInputLayout5.setErrorEnabled(true);
            } else {
                textInputLayout5.setErrorEnabled(false);
            }

        }
    }

    public void showResponse(String response) {

        Log.e("Response", response);

    }

}