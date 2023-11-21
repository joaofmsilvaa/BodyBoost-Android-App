package com.example.bodyboost.views;

import static androidx.core.content.ContextCompat.startActivity;
import static com.example.bodyboost.models.databaseModels.Hash.hashPassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodyboost.R;
import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.IngredientsResponse;
import com.example.bodyboost.models.User;
import com.example.bodyboost.models.UserCompleted;
import com.example.bodyboost.models.UserPlan;
import com.example.bodyboost.models.UserResponse;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private TextInputLayout textInputLayout1;
    private TextInputLayout textInputLayout2;

    private TextView register;

    String usernameString;
    String passwordString;

    private UserViewModel userViewModel;
    private UserCompletedViewModel userCompletedViewModel;
    private WorkoutViewModel workoutViewModel;
    private UserPlanViewModel userPlanViewModel;

    private List<Integer> daysOfWeek = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the needed viewmodels
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userCompletedViewModel = new ViewModelProvider(this).get(UserCompletedViewModel.class);
        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);
        userPlanViewModel = new ViewModelProvider(this).get(UserPlanViewModel.class);

        username = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        textInputLayout1 = findViewById(R.id.textInputLayout1);
        textInputLayout2 = findViewById(R.id.textInputLayout2);
        register = findViewById(R.id.signUp);

        register.setPaintFlags(register.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    // Make an intent to the register activity
    public void signUpMenu(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public void signIn(View view) {

        usernameString = username.getText().toString();
        passwordString = password.getText().toString();

        // If the inserted username and password are not empty proceed
        if (usernameString.trim().length() > 0 && passwordString.trim().length() > 0) {

            // Hash the inserted password
            String hashedpassword = Hash.hashPassword(passwordString);

            // Send the data to the api through the loginUser method in the viewmodel
            userViewModel.loginUser(MainActivity.this, usernameString, hashedpassword, daysOfWeek);

            // Save id of the logged in user
            int userId = userViewModel.getUserIdAPI();

            // If the user was successfully logged in proceed to intent to the home activity
            if(userId > 0){
                Intent intent = new Intent(MainActivity.this, homeActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
                finish();
            }

        }

        // Show warning in the input layout of the empty field
        else {
            if (TextUtils.isEmpty(usernameString)) {
                textInputLayout1.setError("Insert a username");
            } else {
                textInputLayout1.setError(null);
            }
            if (TextUtils.isEmpty(passwordString)) {
                textInputLayout2.setError("Insert a password");
            } else {
                textInputLayout2.setError(null);
            }
        }
    }

}