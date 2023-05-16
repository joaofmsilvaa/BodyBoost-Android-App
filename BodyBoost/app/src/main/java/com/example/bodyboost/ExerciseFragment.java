package com.example.bodyboost;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.bodyboost.Exercise_classes.ExerciseAdapter;
import com.example.bodyboost.Exercise_classes.ExerciseSetDao;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {

    private ExerciseAdapter adapter;
    private AppDatabase db;
    private ExerciseSetDao exerciseSetDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());
        exerciseSetDao = db.getExerciseSetDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inflate the layout for this fragment
        int exerciseDay = ExerciseFragmentArgs.fromBundle(getArguments()).getExerciseDay();

        TextView dayOfWeek = view.findViewById(R.id.dayIndicatorTextView);
        dayOfWeek.setText(dayFinder(exerciseDay));

        RecyclerView recyclerView = view.findViewById(R.id.exerciseRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        adapter = new ExerciseAdapter(exerciseSetDao.getExercisesFromSet(exerciseDay),exerciseSetDao.getAll());

        recyclerView.setAdapter(adapter);
    }

    public static String dayFinder(int givenID){
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        return daysOfWeek[givenID];
    }
}