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
import com.example.bodyboost.R;
import com.example.bodyboost.viewmodels.DaysViewModel;
import com.example.bodyboost.viewmodels.UserPlanViewModel;

public class DaysFragment extends Fragment implements DaysAdapter.DaysAdapterEventListener{

    private DaysAdapter adapter;
    private DaysViewModel daysViewModel;
    private UserPlanViewModel userPlanViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        daysViewModel = new ViewModelProvider(this).get(DaysViewModel.class);
        userPlanViewModel = new ViewModelProvider(this).get(UserPlanViewModel.class);

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

        int planId = userPlanViewModel.getUserPlanById(HomeFragment.userId);

        RecyclerView recyclerView = view.findViewById(R.id.dayRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        adapter = new DaysAdapter(this,daysViewModel.getAll());

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDayClicked(int dayId, View v) {
        NavDirections action = DaysFragmentDirections.actionDaysFragmentToExerciseFragment(dayId);
        Navigation.findNavController(v).navigate(action);
    }
}