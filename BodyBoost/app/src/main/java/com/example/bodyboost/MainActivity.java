package com.example.bodyboost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    String usernameString;
    String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sets the content view to the activity_login layout
        setContentView(R.layout.activity_login);

        // Stores the EditText with the ID "usernameinput" in the username variable
        this.username = findViewById(R.id.usernameInput);
        // Stores the EditText with the ID "passwordInput" in the password variable
        this.password = findViewById(R.id.passwordInput);

    }

    /*
    *
    * signUpMenu - Starts the "registerActivity" activity and finishes the current one using an Intent.
    *
    * @param View view
     */
    public void signUpMenu(View view) {
        Intent intent = new Intent(this, registerActivity.class);
        Log.i("Register activity", "Entering registerActivity");
        startActivity(intent);
        finish();
    }

    /*
     *
     * signIN - Checks if the values stored in the "usernameString" and "passwordString" correspond
     * to the values stored in the "testUsername" and "testPassword" variables. If so the program
     * uses an Intent to start the homeActivity, otherwise it leaves a message in the logcat interface
     * saying that the credentials are incorrect.
     *
     * @param View view
     */
    public void signIN(View view) {
        final String TAG = "Given credentials";

        usernameString = this.username.getText().toString();
        passwordString = this.password.getText().toString();

        String testUsername = "abc";
        String testPassword = "cba";

        if(usernameString.equals(testUsername) && passwordString.equals(testPassword)){
            Log.i("Login", "log-in successfull");
            Log.i(TAG, usernameString + " " + passwordString);

            Intent intent = new Intent(this, homeActivity.class);
            Log.i("Home Activity", "Entering the homeActivity");
            startActivity(intent);
            finish();

        }else{
            Log.i("Login", "Incorrect credentials");
            Log.i(TAG, usernameString + " " + passwordString);
        }

    }
}