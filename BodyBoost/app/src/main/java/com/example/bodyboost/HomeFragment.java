package com.example.bodyboost;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bodyboost.Exercise_classes.ExerciseFragmentArgs;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Meals> mealArrayList;
    private RecyclerView mealsRecyclerView;
    private int percentageValue = 100;
    private TextView percentage;
    private ProgressBar percentageBar;

    private TextView userIdTextView;

    public static int userId;

    private String KEY_USER_ID = "userId";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();

        this.userId = bundle.getInt(this.KEY_USER_ID, 0);

        AppDatabase db = AppDatabase.getInstance(getContext());
        UserDao UserDao = db.getUserDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        percentage = view.findViewById(R.id.percentage);
        percentage.setText(percentageValue + "%");

        percentageBar = view.findViewById(R.id.percentageBar);
        percentageBar.setProgress(percentageValue);

        userIdTextView = view.findViewById(R.id.userIdTextView);
        userIdTextView.setText(Integer.toString(this.userId));

    }


}