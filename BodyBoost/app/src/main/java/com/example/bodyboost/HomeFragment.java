package com.example.bodyboost;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements DaysAdapter.DaysAdapterEventListener {


    public static int userId;

    private DaysDao daysDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();

        String KEY_USER_ID = "userId";
        this.userId = bundle.getInt(KEY_USER_ID, 0);

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

        TextView percentage = view.findViewById(R.id.percentage);
        int percentageValue = 100;
        percentage.setText(percentageValue + "%");

        ProgressBar percentageBar = view.findViewById(R.id.percentageBar);
        percentageBar.setProgress(percentageValue);

        RecyclerView daysRecyclerView = view.findViewById(R.id.curretnDayRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        daysRecyclerView.setLayoutManager(layoutManager);


        DaysAdapter adapter = new DaysAdapter(this, daysDao.getCurrentDay(getCurrentDay()));

        daysRecyclerView.setAdapter(adapter);


    }

    public int getCurrentDay(){
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

        return currentDay;
    }


    @Override
    public void onDayClicked(int dayId, View v) {

        dayId = getCurrentDay();

        NavDirections action = HomeFragmentDirections.actionHomeFragmentToExerciseFragment(dayId);
        Navigation.findNavController(v).navigate(action);
    }
}