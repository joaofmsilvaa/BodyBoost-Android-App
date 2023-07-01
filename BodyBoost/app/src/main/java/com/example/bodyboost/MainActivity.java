package com.example.bodyboost;

import static com.example.bodyboost.Hash.hashPassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private TextInputLayout textInputLayout1;
    private TextInputLayout textInputLayout2;

    private TextView register;

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
        AppDatabase db = AppDatabase.getInstance(this);
        UserDao userDao = db.getUserDao();

        usernameString = username.getText().toString();
        passwordString = password.getText().toString();

        if (usernameString.trim().length() > 0 && passwordString.trim().length() > 0) {
            int userId = userDao.getUserId(usernameString);

            String hashedInputPassword = hashPassword(passwordString);

            int amountOfUsersWithCred = userDao.correspondingUsers(usernameString, hashedInputPassword);

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