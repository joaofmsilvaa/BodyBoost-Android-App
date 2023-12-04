package com.example.bodyboost.views;

import static com.example.bodyboost.views.HomeFragment.userId;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.example.bodyboost.R;
import com.example.bodyboost.models.User;
import com.example.bodyboost.viewmodels.Hash;
import com.example.bodyboost.viewmodels.UserViewModel;
import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private EditText username;
    private EditText password;
    private AutoCompleteTextView goal;
    private EditText weight;
    private EditText height;
    private Button saveChangesBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize the usersViewModel
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        username = findViewById(R.id.usernameEditText);
        goal = findViewById(R.id.goalsACT);
        weight = findViewById(R.id.weightEditText);
        height = findViewById(R.id.heightEditText);
        saveChangesBtn = findViewById(R.id.button3);
        password = findViewById(R.id.passwordEditText);

        // Get a user with the given Id through the getUserId method in the userViewModel
        User user = userViewModel.getUserById(userId);
        username.setText(user.getappUsername());

        // Array of goals available
        String[] goalsArray = {"Lose weight", "Gain mass"};

        // Populate the goals dropdown with the array of goals
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, goalsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goal.setAdapter(adapter);
        goal.setText(user.getObjective(), false);

        // Populate the weight and height textviews with the users information
        weight.setText(Float.toString(user.getWeight()));
        height.setText(Float.toString(user.getHeight()));

        // Find the navigation sidebar
        final NavigationView navigationView = findViewById(R.id.nav_view);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Hide the sidebar initially
        navigationView.setVisibility(View.GONE);

        // Get the menu of items of the navigationView
        Menu navMenu = navigationView.getMenu();
        MenuItem logOutItem = navMenu.findItem(R.id.logOut);
        MenuItem profileItem = navMenu.findItem(R.id.username);

        View headerView = navigationView.getHeaderView(0);
        Button closeButton = headerView.findViewById(R.id.close_button);

        // When the user clicks on the profile item navigate to the profile
        profileItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
                return true;
            }
        });

        // Disable the visibility of the sidebar when the close button is clicked
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setVisibility(View.GONE);
                navigationView.setVisibility(View.GONE);
            }
        });

        // When the logout button is clicked execute the method to terminate the user session
        logOutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                performLogout();
                return true;
            }
        });

        Button userButton = findViewById(R.id.user_button);

        // When the side bar button is clicked set its visibility to visible
        userButton.setOnClickListener(new View.OnClickListener() {
            private boolean isSidebarVisible = false;

            @Override
            public void onClick(View view) {
                isSidebarVisible = !isSidebarVisible;

                if (isSidebarVisible) {
                    navigationView.setVisibility(View.VISIBLE);
                } else {
                    navigationView.setVisibility(View.GONE);
                }
            }
        });

        Button backButton = findViewById(R.id.back_button);

        // When the back button is clicked make an intent to the homeActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            private boolean isSidebarVisible = false;

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, homeActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        });

        // Collect the data in the textviews and proceed to update the current user with them
        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedUsername = username.getText().toString();

                String updatedPassword = password.getText().toString();

                if(updatedPassword.equals("")){
                    updatedPassword = user.getPassword();
                }

                String updatedGoal = goal.getText().toString();
                String oldGoal = user.getObjective();

                float updatedWeight = Float.parseFloat(weight.getText().toString());
                float updatedHeight = Float.parseFloat(height.getText().toString());

                if(!user.getPassword().equals(updatedPassword)){
                    // Encrypt the new password through the hashPassword method
                    updatedPassword = Hash.hashPassword(updatedPassword);
                }

                /* Create a new user object with the updated data and send it to the updateUserAPI
                *  that updated the user data
                */
                User user = new User(userId,updatedUsername,updatedPassword,updatedWeight,updatedHeight,updatedGoal);
                userViewModel.updateUserAPI(user, ProfileActivity.this, oldGoal, updatedGoal);

            }
        });
    }

    // Finish the current activity and go to the MainActivity
    private void performLogout() {

        finishAffinity();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}