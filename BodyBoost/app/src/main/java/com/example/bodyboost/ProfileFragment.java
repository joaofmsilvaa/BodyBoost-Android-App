package com.example.bodyboost;

import static com.example.bodyboost.HomeFragment.userId;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ProfileFragment extends Fragment {

    private AppDatabase db;
    private UserDao userDao;
    private UserPlanDao userPlanDao;
    private UserCompletedDao userCompletedDao;
    private WorkoutPlanDao workoutPlanDao;
    private EditText username;
    private AutoCompleteTextView goal;
    private EditText weight;
    private EditText height;
    private Button saveChangesBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = AppDatabase.getInstance(requireContext());
        userDao = db.getUserDao();
        userPlanDao = db.getUserPlanDao();
        userCompletedDao = db.getUserCompletedDao();
        workoutPlanDao = db.getWorkoutPlanDao();
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

        User user = userDao.getUserById(userId);

        saveChangesBtn = view.findViewById(R.id.button3);

        username = view.findViewById(R.id.usernameEditText);
        goal = view.findViewById(R.id.goalsACT);
        weight = view.findViewById(R.id.weightEditText);
        height = view.findViewById(R.id.heightEditText);

        username.setText(user.getUsername());

        String[] goalsArray = {"Lose weight", "Gain mass"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_item, goalsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goal.setText(user.getObjective());
        goal.setAdapter(adapter);

        weight.setText(Float.toString(user.getWeight()));
        height.setText(Float.toString(user.getHeight()));

        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedUsername = username.getText().toString();
                String updatedGoal = goal.getText().toString();
                float updatedWeight = Float.parseFloat(weight.getText().toString());
                float updatedHeight = Float.parseFloat(height.getText().toString());

                user.setUsername(updatedUsername);
                user.setObjective(updatedGoal);
                user.setWeight(updatedWeight);
                user.setHeight(updatedHeight);

                userDao.updateUser(user);

                userCompletedDao.deleteByUserId(userId);

                int planValue = updatedGoal.equalsIgnoreCase("lose weight") ? 1 : 2;

                UserPlan userPlan = new UserPlan(userId, planValue);
                userPlanDao.insert(userPlan);

                List<Integer> daysOfWeek = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
                for (int day : daysOfWeek) {
                    List<Integer> exerciseIds = workoutPlanDao.getExercisesInDay(planValue, day);
                    for (int exerciseId : exerciseIds) {
                        UserCompleted userCompleted = new UserCompleted(0, userId, day, exerciseId, false);
                        userCompletedDao.insert(userCompleted);
                    }
                }

                Toast.makeText(getContext(), "Changes saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}