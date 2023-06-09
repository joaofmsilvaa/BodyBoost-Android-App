package com.example.bodyboost;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bodyboost.Exercise_classes.DaysAdapter;
import com.example.bodyboost.Exercise_classes.DaysDao;
import com.example.bodyboost.Exercise_classes.ExerciseFragment;
import com.example.bodyboost.Exercise_classes.ExerciseSetAdapter;

import org.w3c.dom.Text;

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


    private DaysDao daysDao;
    private UserCompletedDao userCompletedDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();

        String KEY_USER_ID = "userId";
        this.userId = bundle.getInt(KEY_USER_ID, 0);

        AppDatabase db = AppDatabase.getInstance(requireContext());
        daysDao = db.getDaysDao();
        userCompletedDao = db.getUserCompletedDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int ammountCompleted = userCompletedDao.ammountCompleted(userId,getCurrentDay());
        int ammountOfExercisesInDay = userCompletedDao.ammountOfExercisesInDay(userId,getCurrentDay());

        percentage = view.findViewById(R.id.percentage);

        int percentageValue = 0;

        if(ammountCompleted != 0){
            percentageValue = ammountCompleted / ammountOfExercisesInDay * 100;
        }

        percentage.setText(percentageValue + "%");

        progressBar = view.findViewById(R.id.percentageBar);
        progressBar.setProgress(percentageValue);

        RecyclerView daysRecyclerView = view.findViewById(R.id.curretnDayRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        daysRecyclerView.setLayoutManager(layoutManager);


        DaysAdapter adapter = new DaysAdapter(this, daysDao.getCurrentDay(getCurrentDay()));

        daysRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        updatePercentage();
    }

    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

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

        dayId = getCurrentDay();

        NavDirections action = HomeFragmentDirections.actionHomeFragmentToExerciseFragment(dayId);
        Navigation.findNavController(v).navigate(action);
    }


    public void updatePercentage() {
        AppDatabase db = AppDatabase.getInstance(this.getContext());
        UserCompletedDao userCompletedDao = db.getUserCompletedDao();

        TextView percentage = this.percentage;

        int exercisesInDay = userCompletedDao.ammountOfExercisesInDay(userId, getCurrentDay());
        int amountCompleted = userCompletedDao.ammountCompleted(userId, getCurrentDay());

        double percentageValue = (amountCompleted / (double) exercisesInDay) * 100;
        int percentageInt = (int) percentageValue;

        percentage.setText(percentageInt + "%");

        ProgressBar progressBar = this.progressBar;
        progressBar.setProgress(percentageInt);
    }
}