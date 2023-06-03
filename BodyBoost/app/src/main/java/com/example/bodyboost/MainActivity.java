package com.example.bodyboost;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private TextView usernameAlert;
    private TextView passwordAlert;

    String usernameString;
    String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if user is already logged in
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

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

            username = findViewById(R.id.usernameInput);
            password = findViewById(R.id.passwordInput);
            usernameAlert = findViewById(R.id.textViewAlertName2);
            passwordAlert = findViewById(R.id.textViewAlertPassword2);
        }
    }

    public void signUpMenu(View view) {
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
        finish();
    }

    public void signIN(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        UserDao userDao = db.getUserDao();

        final String TAG = "Given credentials";

        usernameString = username.getText().toString();
        passwordString = password.getText().toString();

        int amountOfUsersWithCred = userDao.correspondingUsers(usernameString, passwordString);

        boolean checker = emptyFieldChecker(usernameString, passwordString, usernameAlert, passwordAlert);

        if (checker) {
            if (amountOfUsersWithCred == 1) {
                Log.i("Login", "log-in successful");
                Log.i(TAG, usernameString + " " + passwordString);

                // Store boolean value in SharedPreferences
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", true);

                int userId = userDao.getUserId(usernameString);
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
    }

    public static boolean emptyFieldChecker(String usernameString, String passwordString, TextView usernameAlert, TextView passwordAlert) {
        final String emptyUsername = "Insert a username!";
        final String emptyPassword = "Insert a password!";
        boolean checker = true;

        if (usernameString.equals("")) {
            usernameAlert.setText(emptyUsername);
            checker = false;
        } else {
            usernameAlert.setText("");
        }

        if (passwordString.equals("")) {
            passwordAlert.setText(emptyPassword);
            checker = false;
        } else {
            passwordAlert.setText("");
        }

        return checker;
    }
}