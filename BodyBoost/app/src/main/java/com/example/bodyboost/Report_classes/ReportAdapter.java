package com.example.bodyboost.Report_classes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder>{

    private List<Report> reportList;
    private Context context;

    public ReportAdapter(List<Report> reports){
        this.reportList = reports;
    }


    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReportViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_reports, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {

        Report current = reportList.get(position);

        int currentValue = current.getWeight();
        holder.weightValue.setText(Integer.toString(currentValue));

        int pos = position;

        if (position > 0) {

            Report previous = reportList.get(position - 1);

            int previousValue = previous.getWeight();

            if (previousValue > currentValue) {
                holder.testTextView.setText("Diminuiu");
            }
            else if(previousValue == currentValue){
                holder.testTextView.setText("Manteve-se");
            }
            else {
                holder.testTextView.setText("Aumentou");
            }
        } else {
            holder.testTextView.setText("Primeiro peso");
        }
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder{

        TextView weightValue;
        TextView testTextView;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            weightValue = itemView.findViewById(R.id.weightValue);
            testTextView = itemView.findViewById(R.id.testTextView);

        }
    }
}
