package com.example.bodyboost.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.R;
import com.example.bodyboost.models.Report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private List<Report> reportList;

    private ReportAdapterEventListener eventListener;

    // Construct the report Adapter with a event listener and the list of reports
    public ReportAdapter(ReportAdapterEventListener eventListener ,List<Report> reports) {
        this.eventListener = eventListener;
        this.reportList = reports;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the list_reports layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_reports, parent, false);
        return new ReportViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        // Store the current report
        Report current = reportList.get(position);

        // Save the date and format it
        long currentDateMillis = current.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = sdf.format(new Date(currentDateMillis));

        // Store the weight of the current report and set it in the textview
        String currentWeight = Float.toString(current.getWeight());
        holder.weightValue.setText(currentWeight + " KG");
        holder.dateTextView.setText(currentDate);

        // When long clicked execute the method "onCardLongClicked" from the event listener
        holder.weightCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(eventListener != null) eventListener.onCardLongClick(current.getReportID());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        // Get the size of the reports list
        return reportList.size();
    }

    // Send a new list of reports to update the reportList variable
    public void updateData(List<Report> reports) {
        this.reportList = reports;
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {

        TextView weightCard;
        TextView weightValue;
        TextView dateTextView;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            weightCard = itemView.findViewById(R.id.weightCard);
            weightValue = itemView.findViewById(R.id.exerciseName);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }

    public interface ReportAdapterEventListener {
        void onCardLongClick(int reportId);
    }
}

