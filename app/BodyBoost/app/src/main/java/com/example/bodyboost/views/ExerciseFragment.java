package com.example.bodyboost.views;

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

import com.example.bodyboost.models.AppDatabase;
import com.example.bodyboost.viewmodels.DaysDao;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.viewmodels.ExerciseSetDao;
import com.example.bodyboost.R;
import com.example.bodyboost.viewmodels.UserCompletedDao;
import com.example.bodyboost.viewmodels.UserPlanDao;
import com.example.bodyboost.viewmodels.WorkoutPlanDao;

import java.util.List;

public class ExerciseFragment extends Fragment implements ExerciseSetAdapter.ExerciseSetAdapterEventListener {
    private int userId;
    private ExerciseSetAdapter adapter;
    private AppDatabase db;
    private int day;
    private DaysDao daysDao;
    private ExerciseSetDao exerciseSetDao;
    private WorkoutPlanDao workoutPlanDao;
    private UserPlanDao userPlanDao;
    private UserCompletedDao userCompletedDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());
        daysDao = db.getDaysDao();
        exerciseSetDao = db.getExerciseSetDao();
        userPlanDao = db.getUserPlanDao();
        userCompletedDao = db.getUserCompletedDao();
        workoutPlanDao = db.getWorkoutPlanDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Retrieve the userId from the arguments using HomeFragmentArgs
        userId = HomeFragment.userId;

        // Stores the given argument (an ID of the selected day) in the exerciseDay variable
        day = ExerciseFragmentArgs.fromBundle(getArguments()).getExerciseDay();

        TextView dayOfWeek = view.findViewById(R.id.dayIndicatorTextView);
        dayOfWeek.setText(daysDao.getDayByID(day));

        RecyclerView recyclerView = view.findViewById(R.id.exerciseRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        int planId = userPlanDao.getUserPlanById(userId);

        List<Exercise> getExercisesForUser = userCompletedDao.getExercisesForUser(userId, day, planId);
        adapter = new ExerciseSetAdapter(this, day ,getExercisesForUser, getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onExerciseCompleted() {
        refreshFragment();
    }

    public void refreshFragment() {

        adapter.updateData(workoutPlanDao.getExercises(HomeFragment.userId, day));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();

        onExerciseCompleted();
    }
}