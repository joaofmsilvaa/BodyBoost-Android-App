package com.example.bodyboost.Report_classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.R;

import org.w3c.dom.Text;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private List<Report> reportList;

    private ReportAdapterEventListener eventListener;

    public ReportAdapter(ReportAdapterEventListener eventListener ,List<Report> reports) {
        this.eventListener = eventListener;
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
        String currentValue = Float.toString(current.getWeight());

        holder.weightValue.setText(currentValue + " KG");
        holder.dateTextView.setText(currentDate);

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
        return reportList.size();
    }

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

