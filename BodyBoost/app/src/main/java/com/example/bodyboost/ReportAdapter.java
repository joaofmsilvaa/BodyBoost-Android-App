package com.example.bodyboost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.MyViewHolder>{

    private ArrayList<Report> reportList;

    public ReportAdapter (ArrayList<Report> reportList){
        this.reportList = reportList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView weightText;

        public MyViewHolder(final View view){
            super(view);
            weightText = view.findViewById(R.id.weightValue);
        }
    }

    @NonNull
    @Override
    public ReportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_reports, parent, false);
        return new ReportAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.MyViewHolder holder, int position) {
        String name = reportList.get(position).getWeight();
        holder.weightText.setText(name);
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

}
