package com.example.bodyboost.views;
import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.bodyboost.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homeActivity extends AppCompatActivity {

    private Button userButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the userId from the variable in the homeFragment
        int userId = HomeFragment.userId;

        final NavigationView navigationView = findViewById(R.id.nav_view);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // Stores a fragment with the id "fragmentContainerView" in the navHostFragment variable
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        // Sets the navigation controller for the fragment stored in the navHostFragment variable
        NavController navController = navHostFragment.getNavController();
        // Stores the bottom navigation view with the id "bottomNavigationView" in the "bottomNav" variable
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        // Sets that the navigation controller is used in the bottom navigation stored in the "bottomNav" variable
        NavigationUI.setupWithNavController(bottomNav, navController);
        // Hide the sidebar initially
        navigationView.setVisibility(View.GONE);

        Menu navMenu = navigationView.getMenu();
        MenuItem logOutItem = navMenu.findItem(R.id.logOut);
        MenuItem profileItem = navMenu.findItem(R.id.username);
        MenuItem visitWebsite = navMenu.findItem(R.id.visitWebsite);

        View headerView = navigationView.getHeaderView(0);
        Button closeButton = headerView.findViewById(R.id.close_button);

        // Navigate to the profileActivity
        profileItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(homeActivity.this, ProfileActivity.class);
                startActivity(intent);
                return true;
            }
        });

        // Redirect the user to the github repository
        visitWebsite.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://joao7640.github.io/BodyBoost-Android-App/"));
                startActivity(viewIntent);
                return false;
            }
        });

        // Disable visibility of side bar
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setVisibility(View.GONE);
                navigationView.setVisibility(View.GONE);
            }
        });

        // Logout user through the performLogout method
        logOutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
            performLogout();
            return true;
            }
        });

        Button userButton = findViewById(R.id.user_button);

        // Show the sidebar when the button is clicked
        userButton.setOnClickListener(new View.OnClickListener() {
            private boolean isSidebarVisible = false;

            @Override
            public void onClick(View view) {
                isSidebarVisible = !isSidebarVisible;

                if (isSidebarVisible) {
                    navigationView.setVisibility(View.VISIBLE);
                }
                else {
                    navigationView.setVisibility(View.GONE);
                }
            }
        });
    }

    // Finish current activity and go back to the MainActivity ( login page )
    private void performLogout() {

        finishAffinity();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}