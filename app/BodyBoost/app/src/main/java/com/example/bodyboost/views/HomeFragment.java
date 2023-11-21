package com.example.bodyboost.views;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DaysDao;
import com.example.bodyboost.R;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.viewmodels.DaysViewModel;
import com.example.bodyboost.viewmodels.UserCompletedViewModel;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements DaysAdapter.DaysAdapterEventListener{

    public static int userId;
    public ProgressBar progressBar;
    public TextView percentage;
    private DaysViewModel daysViewModel;
    private UserCompletedViewModel userCompletedViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();

        String KEY_USER_ID = "userId";

        // Store the userId sent in the bundle
        this.userId = bundle.getInt(KEY_USER_ID, 0);

        // Initialize the needed viewmodels
        daysViewModel = new ViewModelProvider(this).get(DaysViewModel.class);
        userCompletedViewModel = new ViewModelProvider(this).get(UserCompletedViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the ammount of exercises completed
        int ammountCompleted = userCompletedViewModel.ammountCompleted(userId,getCurrentDay());

        // Get the ammount of exercises in the day
        int ammountOfExercisesInDay = userCompletedViewModel.ammountOfExercisesInDay(userId,getCurrentDay());

        percentage = view.findViewById(R.id.percentage);
        progressBar = view.findViewById(R.id.percentageBar);

        int percentageValue = 0;

        if(ammountCompleted != 0){
            // Calculate the percentage of exercises completed in current day
            percentageValue = ammountCompleted / ammountOfExercisesInDay * 100;
        }

        // set the percentage in the textview
        percentage.setText(percentageValue + "%");
        progressBar.setProgress(percentageValue);

        RecyclerView daysRecyclerView = view.findViewById(R.id.curretnDayRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        daysRecyclerView.setLayoutManager(layoutManager);

        // Initialize the adapter
        DaysAdapter adapter = new DaysAdapter(this, daysViewModel.getCurrentDay(getCurrentDay()));

        daysRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        updatePercentage();
    }

    // Calculate the current day of the week
    public static int getCurrentDay() {
        // Get instance of object calanedar
        Calendar calendar = Calendar.getInstance();

        // Get the day of week from calendar variable
        int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

        // Depending on the value of the currentDay variable set the current day
        switch (currentDay) {
            case Calendar.MONDAY:
                currentDay = 0;
                break;
            case Calendar.TUESDAY:
                currentDay = 1;
                break;
            case Calendar.WEDNESDAY:
                currentDay = 2;
                break;
            case Calendar.THURSDAY:
                currentDay = 3;
                break;
            case Calendar.FRIDAY:
                currentDay = 4;
                break;
            case Calendar.SATURDAY:
                currentDay = 5;
                break;
            case Calendar.SUNDAY:
                currentDay = 6;
                break;
        }

        return currentDay;
    }


    @Override
    public void onDayClicked(int dayId, View v) {
        // When the home card is clicked navigate to the exerciseFragment of the designated day
        NavDirections action = HomeFragmentDirections.actionHomeFragmentToExerciseFragment(dayId);
        Navigation.findNavController(v).navigate(action);

    }

    // Calculate the percentage of the completed exercises in the day
    public void updatePercentage() {

        TextView percentage = this.percentage;

        int exercisesInDay = userCompletedViewModel.ammountOfExercisesInDay(userId, getCurrentDay());
        int amountCompleted = userCompletedViewModel.ammountCompleted(userId, getCurrentDay());

        double percentageValue = (amountCompleted / (double) exercisesInDay) * 100;
        int percentageInt = (int) percentageValue;

        percentage.setText(percentageInt + "%");

        ProgressBar progressBar = this.progressBar;
        progressBar.setProgress(percentageInt);
    }
}