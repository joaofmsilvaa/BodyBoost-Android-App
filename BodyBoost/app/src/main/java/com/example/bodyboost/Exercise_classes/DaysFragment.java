package com.example.bodyboost.Exercise_classes;

import android.content.Context;
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
import com.example.bodyboost.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaysFragment} factory method to
 * create an instance of this fragment.
 */
public class DaysFragment extends Fragment{

    private DaysAdapter adapter;
    private AppDatabase db;
    private DaysDao daysDao;

    private Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());
        daysDao = db.getDaysDao();

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

        RecyclerView recyclerView = view.findViewById(R.id.dayRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        adapter = new DaysAdapter(daysDao.getAll());

        recyclerView.setAdapter(adapter);
    }
}