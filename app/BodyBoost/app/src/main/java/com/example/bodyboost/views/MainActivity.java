package com.example.bodyboost.views;

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
import com.example.bodyboost.viewmodels.UserViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private TextInputLayout textInputLayout1;
    private TextInputLayout textInputLayout2;

    private TextView register;

    String usernameString;
    String passwordString;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if user is already logged in
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        if (isLoggedIn) {

            // User is logged in, navigate to homeActivity
            int userId = sharedPreferences.getInt("userId", 0);
            Intent intent = new Intent(this, homeActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
            finish();
        } else {
            // User is not logged in, proceed with the login screen
            setContentView(R.layout.activity_login);

            username = findViewById(R.id.emailInput);
            password = findViewById(R.id.passwordInput);
            textInputLayout1 = findViewById(R.id.textInputLayout1);
            textInputLayout2 = findViewById(R.id.textInputLayout2);
            register = findViewById(R.id.signUp);
            register.setPaintFlags(register.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);


        }
    }

    public void signUpMenu(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public void signIn(View view) {

        usernameString = username.getText().toString();
        passwordString = password.getText().toString();

        if (usernameString.trim().length() > 0 && passwordString.trim().length() > 0) {
            int userId = userViewModel.getUserId(usernameString);

            String hashedInputPassword = hashPassword(passwordString);

            int amountOfUsersWithCred = userViewModel.correspondingUsers(usernameString, hashedInputPassword);

            if (amountOfUsersWithCred == 1) {

                // Store boolean value in SharedPreferences
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.putInt("userId", userId);

                editor.apply();

                Intent intent = new Intent(this, homeActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "The credentials don't match any account", Toast.LENGTH_SHORT).show();
            }
        }

        else{
            if(TextUtils.isEmpty(usernameString)){
                textInputLayout1.setError("Insert a username");
            }
            else{
                textInputLayout1.setError(null);
            }
            if(TextUtils.isEmpty(passwordString)){
                textInputLayout2.setError("Insert a password");
            }
            else{
                textInputLayout2.setError(null);
            }
        }
    }


}