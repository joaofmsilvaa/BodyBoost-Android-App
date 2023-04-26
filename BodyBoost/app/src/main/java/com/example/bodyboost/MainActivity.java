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
    private Button loginBtn;

    String usernameString;
    String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginBtn = findViewById(R.id.loginBtn);
        this.username = findViewById(R.id.usernameInput);
        this.password = findViewById(R.id.passwordInput);


        /*setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNav, navController);*/

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {

        return super.onCreateView(name, context, attrs);
    }

    public void signUpMenu(View view) {
        Intent intent = new Intent(this, registerActivity.class);
        Log.i("Register activity", "Entering registerActivity");
        startActivity(intent);
        finish();
    }

    public void signIN(View view) {
        usernameString = this.username.getText().toString();
        passwordString = this.password.getText().toString();

        if(usernameString.equals("a") && passwordString.equals("a")){
            Log.i("Login", "log-in successfull");
            Log.i("variables", usernameString + " " + passwordString);
        }else{
            Log.i("Login", "log-in error");
            Log.i("variables", usernameString + " " + passwordString);
        }

    }
}