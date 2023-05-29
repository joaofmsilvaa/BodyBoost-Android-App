package com.example.bodyboost;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.DaysAdapter;
import com.example.bodyboost.Exercise_classes.DaysDao;
import com.example.bodyboost.Exercise_classes.ExerciseFragmentArgs;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements DaysAdapter.DaysAdapterEventListener {


    public static int userId;
    private String KEY_USER_ID = "userId";

    private int percentageValue = 100;
    private TextView percentage;
    private ProgressBar percentageBar;

    private DaysAdapter adapter;
    private DaysDao daysDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();

        this.userId = bundle.getInt(this.KEY_USER_ID, 0);

        AppDatabase db = AppDatabase.getInstance(getContext());
        daysDao = db.getDaysDao();

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

        RecyclerView daysRecyclerView = view.findViewById(R.id.curretnDayRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        daysRecyclerView.setLayoutManager(layoutManager);

        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_WEEK);


        switch (currentDay) {
            case 1:
                currentDay = 6;
                break;
            case 2:
                currentDay = 0;
                break;
            case 3:
                currentDay = 1;
                break;
            case 4:
                currentDay = 2;
                break;
            case 5:
                currentDay = 3;
                break;
            case 6:
                currentDay = 4;
                break;
            case 7:
                currentDay = 5;
        }


        adapter = new DaysAdapter(this,daysDao.getCurrentDay(currentDay));

        daysRecyclerView.setAdapter(adapter);


    }


    @Override
    public void onDayClicked(int dayId, View v) {
        // TO-DO Finish the interface
        NavDirections action = HomeFragmentDirections.actionHomeFragmentToExerciseFragment(dayId);
        Navigation.findNavController(v).navigate(action);
    }
}