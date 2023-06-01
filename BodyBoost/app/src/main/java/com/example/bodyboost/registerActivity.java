package com.example.bodyboost;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registerActivity extends AppCompatActivity{


    private EditText username;
    private EditText password;

    private EditText goal;

    private EditText height;
    private EditText weight;

    private String usernameString;
    private String passwordString;
    private String goalString;
    private String heightString;
    private String weightString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sets the content view to the activity_login layout
        setContentView(R.layout.fragment_register);

        // Stores the EditText with the ID "usernameinput" in the username variable
        this.username = findViewById(R.id.usernameEditText);
        // Stores the EditText with the ID "passwordInput" in the password variable
        this.password = findViewById(R.id.passwordEditText);

        this.goal = findViewById(R.id.goalEditText);
        this.height = findViewById(R.id.heightEditText);
        this.weight = findViewById(R.id.weightEditText);

    }

    public void signINMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        Log.i("Main activity", "Entering the main activity");
        startActivity(intent);
        finish();
    }

    public void signUp(View view) {

        AppDatabase db = AppDatabase.getInstance(this);
        UserDao userDao = db.getUserDao();

        final String TAG = "Given credentials";

        usernameString = this.username.getText().toString();
        passwordString = this.password.getText().toString();
        goalString = this.goal.getText().toString();
        heightString = this.height.getText().toString();
        weightString = this.weight.getText().toString();

        float weightFloat = Float.parseFloat(weightString);
        float heightFloat = Float.parseFloat(heightString);

        int ammountOfUsersWithCred = userDao.correspondingUsers(usernameString, passwordString);

        if (ammountOfUsersWithCred == 0) {
            User user = new User(0, usernameString, passwordString, weightFloat, heightFloat, goalString);

            userDao.insert(user);

            Intent intent = new Intent(this, homeActivity.class);
            Log.i("Home Activity", "Entering the homeActivity");

            int userId = userDao.getUserId(usernameString);
            intent.putExtra("userId", userId);
            startActivity(intent);
            finish();
        }
    }
}

