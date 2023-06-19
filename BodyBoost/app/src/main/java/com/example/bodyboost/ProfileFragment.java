package com.example.bodyboost;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    AppDatabase db;
    UserDao userDao;
    EditText username;
    AutoCompleteTextView goal;
    EditText weight;
    EditText height;

    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = AppDatabase.getInstance(this.getContext());
        userDao = db.getUserDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        User user = userDao.getUserById(HomeFragment.userId);

        username = view.findViewById(R.id.usernameEditText);
        goal = view.findViewById(R.id.goalsACT);
        weight = view.findViewById(R.id.weightEditText);
        height = view.findViewById(R.id.heightEditText);

        username.setText(user.username);

        String[] goals_array = {"Lose weight", "Gain mass"};

        // Create an ArrayAdapter using the goalsArray and the custom dropdown item layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), R.layout.dropdown_item, goals_array);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        goal.setText(user.objective);

        // Apply the adapter to the spinner
        goal.setAdapter(adapter);



        weight.setText(Float.toString(user.weight));
        height.setText(Float.toString(user.height));
    }
}