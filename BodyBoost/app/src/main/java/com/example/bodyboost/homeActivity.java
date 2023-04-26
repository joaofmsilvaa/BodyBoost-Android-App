package com.example.bodyboost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}