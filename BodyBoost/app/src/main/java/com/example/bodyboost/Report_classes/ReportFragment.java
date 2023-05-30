package com.example.bodyboost.Report_classes;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import android.widget.Toast;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.HomeFragment;
import com.example.bodyboost.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReportFragment} factory method to
 * create an instance of this fragment.
 */
public class ReportFragment extends Fragment implements ReportAdapter.ReportAdapterEventListener {

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

                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH) + 1;
                int day = now.get(Calendar.DAY_OF_MONTH);
                int hour = now.get(Calendar.HOUR_OF_DAY);
                int minute = now.get(Calendar.MINUTE);
                int second = now.get(Calendar.SECOND);

                String currentDate = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;


                float weight = Float.parseFloat(weightInput.getText().toString());

                reportDao.insert(new Report(0, HomeFragment.userId ,weight, currentDate));
                weightInput.setText("");

                Toast.makeText(getContext(),"Report added",Toast.LENGTH_SHORT).show();

                refreshFragment();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        List<Report> getAll = reportDao.getAll(HomeFragment.userId);
        adapter = new ReportAdapter(this, getAll);

        recyclerView.setAdapter(adapter);
    }

    public void refreshFragment() {

        adapter.updateData(reportDao.getAll(HomeFragment.userId));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCardLongClick(int reportId) {
        this.reportDao = AppDatabase.getInstance(getActivity()).getReportDao();
        Report report = this.reportDao.getById(reportId);

        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setTitle("Delete Report");
        builder.setMessage("Do you really want to delete this report?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getContext(),"Report deleted",Toast.LENGTH_SHORT).show();

                reportDao.delete(report);
                List<Report> newList = reportDao.getAll(report.getReportID());
                refreshFragment();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}