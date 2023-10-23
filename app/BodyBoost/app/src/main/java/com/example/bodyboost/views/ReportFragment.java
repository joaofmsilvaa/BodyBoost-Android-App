package com.example.bodyboost.views;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodyboost.models.AppDatabase;
import com.example.bodyboost.R;
import com.example.bodyboost.models.Report;
import com.example.bodyboost.viewmodels.ReportDao;

import java.text.SimpleDateFormat;

import java.util.Date;
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
    private TextView messageTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain an instance of ReportDatabase and ReportDao
        db = AppDatabase.getInstance(getContext());
        reportDao = db.getReportDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        List<Report> getAll = reportDao.getAll(HomeFragment.userId);

        if(getAll.size() > 0){
            messageTextView.setText("");
        }
        else{
            messageTextView.setText("You haven't inserted any weight");
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.reportRecyclerView);
        EditText weightInput = view.findViewById(R.id.weightIputEditText);

        weightInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        messageTextView = view.findViewById(R.id.textView3);

        Button insertWeight = view.findViewById(R.id.insertWeightButton);
        insertWeight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inputText = weightInput.getText().toString().trim();
                if (!inputText.isEmpty()) {
                    float weight = Float.parseFloat(inputText);

                    long currentDateMillis = System.currentTimeMillis();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String currentDate = sdf.format(new Date(currentDateMillis));

                    reportDao.insert(new Report(0, HomeFragment.userId, weight, currentDateMillis));
                    weightInput.setText("");

                    Toast.makeText(getContext(), "Report added", Toast.LENGTH_SHORT).show();

                    refreshFragment();
                } else {
                    // Handle empty input, display an error message, or take appropriate action.
                    Toast.makeText(getContext(), "Please enter a weight value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        List<Report> getAll = reportDao.getAll(HomeFragment.userId);

        if(getAll.size() > 0){
            messageTextView.setText("");
        }
        else{
            messageTextView.setText("You haven't inserted any weight");
        }

        adapter = new ReportAdapter(this, getAll);

        recyclerView.setAdapter(adapter);
    }

    public void refreshFragment() {

        adapter.updateData(reportDao.getAll(HomeFragment.userId));

        List<Report> getAll = reportDao.getAll(HomeFragment.userId);

        if(getAll.size() > 0){
            messageTextView.setText("");
        }
        else{
            messageTextView.setText("You haven't inserted any weight");
        }

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