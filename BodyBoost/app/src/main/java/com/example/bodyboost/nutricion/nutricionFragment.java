package com.example.bodyboost.nutricion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.Exercise_classes.DaysAdapter;
import com.example.bodyboost.Exercise_classes.DaysDao;
import com.example.bodyboost.Feed_classes.Feed;
import com.example.bodyboost.Feed_classes.FeedAdapter;
import com.example.bodyboost.HomeFragment;
import com.example.bodyboost.R;
import com.example.bodyboost.UserPlanDao;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nutricionFragment#} factory method to
 * create an instance of this fragment.
 */
public class nutricionFragment extends Fragment {

    private MealsAdapter adapter;
    private AppDatabase db;

    private MealsDao mealsDao;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());

        mealsDao = db.getMealsDao();

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

        List<Meals> getAll = mealsDao.getAll();
        adapter = new MealsAdapter(getAll);

        recyclerView.setAdapter(adapter);
    }
}