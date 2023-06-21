package com.example.bodyboost;
import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homeActivity extends AppCompatActivity {

    private Button userButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getInstance(this);
        UserDao userDao = db.getUserDao();
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

        View headerView = navigationView.getHeaderView(0);
        Button closeButton = headerView.findViewById(R.id.close_button);

        profileItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(homeActivity.this, ProfileActivity.class);
                startActivity(intent);
                return true;
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setVisibility(View.GONE);
                navigationView.setVisibility(View.GONE);
            }
        });

        logOutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
            performLogout();
            return true;
            }
        });

        Button userButton = findViewById(R.id.user_button);

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


    private void performLogout() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.remove("userId");
        editor.apply();

        finishAffinity();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}