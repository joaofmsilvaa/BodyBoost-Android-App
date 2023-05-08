package com.example.bodyboost;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bodyboost.Exercise_classes.Workout;
import com.example.bodyboost.Exercise_classes.workoutAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Workout> exerciseArrayList;
    private ArrayList<Meal> mealArrayList;
    private RecyclerView exerciseRecyclerView;
    private RecyclerView mealsRecyclerView;
    private int percentageValue = 100;
    private TextView percentage;
    private ProgressBar percentageBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        exerciseRecyclerView = view.findViewById(R.id.exerciseRecyclerView);
        mealsRecyclerView = view.findViewById(R.id.mealRecyclerView);

        exerciseArrayList = new ArrayList<>();
        setExerciseInfo();
        setExerciseAdapter();

        mealArrayList = new ArrayList<>();
        setMealInfo();
        setMealsAdapter();

    }

    private void setExerciseAdapter() {
        workoutAdapter exerciseAdapter = new workoutAdapter(exerciseArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        exerciseRecyclerView.setLayoutManager(layoutManager);
        exerciseRecyclerView.setItemAnimator(new DefaultItemAnimator());
        exerciseRecyclerView.setAdapter(exerciseAdapter);
    }

    private void setMealsAdapter() {
        mealAdapter mealAdapter = new mealAdapter(mealArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        mealsRecyclerView.setLayoutManager(layoutManager);
        mealsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mealsRecyclerView.setAdapter(mealAdapter);
    }

    private void setExerciseInfo() {
        exerciseArrayList.add(new Workout("Flexões"));
        exerciseArrayList.add(new Workout("Abdominais"));
        exerciseArrayList.add(new Workout("Agachamentos"));
    }

    private void setMealInfo() {
        mealArrayList.add(new Meal("Frango"));
        mealArrayList.add(new Meal("Arroz"));
        mealArrayList.add(new Meal("Feijão"));
    }

}