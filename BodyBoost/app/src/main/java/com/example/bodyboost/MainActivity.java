package com.example.bodyboost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private TextView usernameAlert;

    private TextView passwordAlert;

    String usernameString;
    String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        // Sets the content view to the activity_login layout
        setContentView(R.layout.activity_login);

        // Stores the EditText with the ID "usernameinput" in the username variable
        this.username = findViewById(R.id.usernameInput);
        // Stores the EditText with the ID "passwordInput" in the password variable
        this.password = findViewById(R.id.passwordInput);
        // Stores the textView with the ID "textViewAlertName2" in the usernameAlert variable
        this.usernameAlert = findViewById(R.id.textViewAlertName2);
        // Stores the textView with the ID "textViewAlertPassword2" in the passwordAlert variable
        this.passwordAlert = findViewById(R.id.textViewAlertPassword2);*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Stores a fragment with the id "fragmentContainerView" in the navHostFragment variable
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        // Sets the navigation controller for the fragment stored in the navHostFragment variable
        NavController navController = navHostFragment.getNavController();
        // Stores the bottom navigation view with the id "bottomNavigationView" in the "bottomNav" variable
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        // Sets that the navigation controller is used in the bottom navigation stored in the "bottomNav" variable
        NavigationUI.setupWithNavController(bottomNav, navController);
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

        emptyFieldChecker(usernameString, passwordString, usernameAlert, passwordAlert);

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

    public static void emptyFieldChecker(String usernameString, String passwordString, TextView usernameAlert, TextView passwordAlert){
        // Stores the alert messages in the proper variables
        final String emptyUsername = "Insert a username!";
        final String emptyPassword = "Insert a password!";

        if(usernameString.equals("")){
            usernameAlert.setText(emptyUsername);

        }

        if(!usernameString.equals("")){
            usernameAlert.setText("");
        }

        if(passwordString.equals("")){
            passwordAlert.setText(emptyPassword);

        }

        if(!passwordString.equals("")){
            passwordAlert.setText("");
        }
    }

    public void bmiCalculator(View view) {
        Button bmiButton = view.findViewById(R.id.bmiButton);

        bmiCalculator bmiDialog = new bmiCalculator();
        bmiDialog.show(getSupportFragmentManager(), "bmiCalculator");

        bmiButton.setText("clicked");
    }

}