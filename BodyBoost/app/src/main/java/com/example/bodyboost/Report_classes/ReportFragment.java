package com.example.bodyboost.Report_classes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bodyboost.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReportFragment} factory method to
 * create an instance of this fragment.
 */
public class ReportFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // obter uma instância do ContactDao
        ReportDatabase db = ReportDatabase.getInstance(this.getContext());
        ReportDao reportDao = db.getReportDao();


        RecyclerView recyclerView = view.findViewById(R.id.reportRecyclerView);
        EditText weightInput = view.findViewById(R.id.weightIputEditText);

        Button inserWeight = (Button) view.findViewById(R.id.insertWeightButton);
        inserWeight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int weight = Integer.parseInt(weightInput.getText().toString());
                reportDao.insert(new Report(0, weight ));

            }
        });

        List<Report> reportList = reportDao.getAll();
        if (reportList.size() == 0) {
            reportDao.insert(new Report(0, 90));
            reportDao.insert(new Report(0, 80));
            reportDao.insert(new Report(0, 80));
            reportDao.insert(new Report(0, 95));
            reportDao.insert(new Report(0, 85));
            reportList = reportDao.getAll();
        }

        // criar um objeto do tipo ContactAdapter (que extende Adapter)
        ReportAdapter adapter = new ReportAdapter(reportDao.getAll());

        // criar um objecto do tipo LinearLayoutManager para ser utilizado na RecyclerView
        // o LinearLayoutManager tem como orientação default a orientação Vertical
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());

        // Definir que a RecyclerView utiliza como Adapter o objeto que criámos anteriormente
        recyclerView.setAdapter(adapter);
        // Definir que a RecyclerView utiliza como LayoutManager o objeto que criámos anteriormente
        recyclerView.setLayoutManager(layoutManager);
    }

}