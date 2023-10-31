package com.example.bodyboost.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.R;
import com.example.bodyboost.viewmodels.MealsViewModel;
import com.example.bodyboost.viewmodels.ReportViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nutricionFragment#} factory method to
 * create an instance of this fragment.
 */
public class nutricionFragment extends Fragment {

    private MealsAdapter adapter;

    private MealsViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MealsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nutricion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.mealsRecyclerVIEW);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);


        viewModel.getMeals().observe(getViewLifecycleOwner(), meals -> {

            adapter = new MealsAdapter(meals);
            recyclerView.setAdapter(adapter);
        });

    }
}