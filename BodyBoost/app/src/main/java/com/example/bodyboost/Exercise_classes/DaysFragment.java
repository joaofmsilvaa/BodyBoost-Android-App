package com.example.bodyboost.Exercise_classes;

import android.content.Context;
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

import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.HomeFragment;
import com.example.bodyboost.R;
import com.example.bodyboost.UserPlanDao;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaysFragment} factory method to
 * create an instance of this fragment.
 */
public class DaysFragment extends Fragment implements DaysAdapter.DaysAdapterEventListener{

    private DaysAdapter adapter;
    private AppDatabase db;
    private DaysDao daysDao;

    private UserPlanDao userPlanDao;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());

        daysDao = db.getDaysDao();
        userPlanDao = db.getUserPlanDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_days, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int planId = userPlanDao.getUserPlanById(HomeFragment.userId);

        RecyclerView recyclerView = view.findViewById(R.id.dayRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        adapter = new DaysAdapter(this,daysDao.getAll());

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDayClicked(int dayId, View v) {
        NavDirections action = DaysFragmentDirections.actionDaysFragmentToExerciseFragment(dayId);
        Navigation.findNavController(v).navigate(action);
    }
}