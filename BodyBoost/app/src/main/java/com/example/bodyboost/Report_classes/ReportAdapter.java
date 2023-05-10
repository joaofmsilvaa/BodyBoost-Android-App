package com.example.bodyboost.Report_classes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.R;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private List<Report> reportList;

    public ReportAdapter(List<Report> reports) {
        this.reportList = reports;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_reports, parent, false);
        return new ReportViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Report current = reportList.get(position);

        String currentDate = current.getDate();
        int currentValue = current.getWeight();

        holder.weightValue.setText(currentValue + " KG");
        holder.dateTextView.setText(currentDate);

        if (position > 0) {
            Report previous = reportList.get(position - 1);
            int previousValue = previous.getWeight();

            if (previousValue > currentValue) {
                holder.testImageView.setImageResource(R.drawable.down_report);
            } else if (previousValue == currentValue) {
                holder.testImageView.setImageResource(R.drawable.same_report);
            } else {
                holder.testImageView.setImageResource(R.drawable.up_report);
            }
        } else {
            holder.testImageView.setImageResource(R.drawable.same_report);
        }
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public void updateData(List<Report> reports) {
        this.reportList = reports;
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView weightValue;
        TextView dateTextView;
        ImageView testImageView;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            weightValue = itemView.findViewById(R.id.weightValue);
            testImageView = itemView.findViewById(R.id.imageViewTest);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}

