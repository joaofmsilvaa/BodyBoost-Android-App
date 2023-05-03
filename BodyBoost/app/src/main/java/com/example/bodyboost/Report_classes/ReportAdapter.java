package com.example.bodyboost.Report_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.R;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportViewHolder>{

    ArrayList<Report> reportList;
    Context context;

    public ReportAdapter(Context context, ArrayList<Report> reports){
        this.reportList = reports;
        this.context = context;
    }


    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReportViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_reports, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        holder.weightValue.setText(reportList.get(position).getWeight());

    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }
}
