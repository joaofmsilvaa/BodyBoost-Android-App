package com.example.bodyboost.views;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
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

import com.example.bodyboost.R;
import com.example.bodyboost.models.Report;
import com.example.bodyboost.viewmodels.ReportViewModel;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportFragment extends Fragment implements ReportAdapter.ReportAdapterEventListener {

    private ReportAdapter adapter;
    private ReportViewModel viewModel;

    private TextView messageTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the report view-model
        viewModel = new ViewModelProvider(this).get(ReportViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the "fragment_report" layout
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Creates an observer with the given Live data from the getReports method that returns all reports
        viewModel.getReports(HomeFragment.userId).observe(this, reports -> {
            if(reports.size() > 0){
                messageTextView.setText("");
                adapter.updateData(reports);
            }

        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.reportRecyclerView);
        EditText weightInput = view.findViewById(R.id.weightIputEditText);

        weightInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        messageTextView = view.findViewById(R.id.textView3);
        Button insertWeight = view.findViewById(R.id.insertWeightButton);

        /* When the "insertWeight" button is clicked the method stores the weight in a variable
         * and then creates a new report with the data and proceeds to call the "createReport"
         * method from the view-model that stores the report in the database
         */
        insertWeight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inputText = weightInput.getText().toString().trim();
                if (!inputText.isEmpty()) {
                    float weight = Float.parseFloat(inputText);

                    long currentDateMillis = System.currentTimeMillis();

                    // Setup viewModel
                    viewModel = new ViewModelProvider(getActivity()).get(ReportViewModel.class);

                    // Call the view-model method to store the report
                    viewModel.createReport(new Report(0, HomeFragment.userId, weight, currentDateMillis));
                    weightInput.setText("");

                    Toast.makeText(getContext(), "Report added", Toast.LENGTH_SHORT).show();

                    refreshFragment();
                } else {
                    // If the weight field is empty make a toast notifying the user
                    Toast.makeText(getContext(), "Please enter a weight value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        // Observe the Live Data given by the getReports method which returns all the reports
        viewModel.getReports(HomeFragment.userId).observe(getViewLifecycleOwner(), reports -> {

            if(reports.size() > 0){
                messageTextView.setText("");
            }

            adapter = new ReportAdapter(this, reports);
            recyclerView.setAdapter(adapter);
        });

    }

    public void refreshFragment() {
        // Get all the reports and send them to the adapter
        viewModel.getReports(HomeFragment.userId).observe(getViewLifecycleOwner(), reports -> {

            if(reports.size() > 0){
                messageTextView.setText("");
            }
            else{
                messageTextView.setText("You haven't inserted any weight");
            }

            adapter.updateData(reports);
            adapter.notifyDataSetChanged();

        });
    }

    @Override
    public void onCardLongClick(int reportId) {

        Report report = viewModel.getById(reportId);

        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setTitle("Delete Report");
        builder.setMessage("Do you really want to delete this report?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getContext(),"Report deleted",Toast.LENGTH_SHORT).show();

                viewModel.deleteReport(report);
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