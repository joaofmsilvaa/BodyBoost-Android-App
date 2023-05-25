package com.example.bodyboost.Report_classes;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReportFragment} factory method to
 * create an instance of this fragment.
 */
public class ReportFragment extends Fragment {

    private ReportAdapter adapter;
    private AppDatabase db;
    private ReportDao reportDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain an instance of ReportDatabase and ReportDao
        db = AppDatabase.getInstance(getContext());
        reportDao = db.getReportDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.reportRecyclerView);
        EditText weightInput = view.findViewById(R.id.weightIputEditText);

        weightInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        Button insertWeight = view.findViewById(R.id.insertWeightButton);
        insertWeight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

                float weight = Float.parseFloat(weightInput.getText().toString());

                reportDao.insert(new Report(0, weight, currentDate));
                weightInput.setText("");

                refreshFragment();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        List<Report> getAll = reportDao.getAll();
        adapter = new ReportAdapter(getAll);

        recyclerView.setAdapter(adapter);
    }

    public void refreshFragment() {

        adapter.updateData(reportDao.getAll());

        adapter.notifyDataSetChanged();
    }
}