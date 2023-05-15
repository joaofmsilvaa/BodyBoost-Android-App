package com.example.bodyboost;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int exerciseDay = ExerciseFragmentArgs.fromBundle(getArguments()).getExerciseDay();

        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }
}