package com.example.bodyboost.Exercise_classes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.bodyboost.R;
import com.example.bodyboost.Report_classes.Report;
import com.example.bodyboost.Report_classes.ReportAdapter;
import com.example.bodyboost.Report_classes.ReportDao;
import com.example.bodyboost.Report_classes.ReportDatabase;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link workoutFragment} factory method to
 * create an instance of this fragment.
 */
public class workoutFragment extends Fragment {

    private DaysAdapter adapter;
    private DaysDatabase db;
    private DaysDao daysDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain an instance of ReportDatabase and ReportDao
        db = DaysDatabase.getInstance(getContext());
        daysDao = db.getDaysDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false);
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