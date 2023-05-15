package com.example.bodyboost.Exercise_classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.R;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DaysViewHolder> {

    private List<Days> daysList;

    public DaysAdapter(List<Days> days) {
        this.daysList = days;
    }


    @NonNull
    @Override
    public DaysAdapter.DaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_days, parent, false);
        return new DaysAdapter.DaysViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DaysAdapter.DaysViewHolder holder, int position) {
        Days days = this.daysList.get(position);
        String numberOfExercises = Integer.toString(days.getNumberOfExercises());
        String concludedExercises = Integer.toString(days.getConcludedExercises());

        holder.daysTextView.setText(days.getDay());
        holder.countTextView.setText(concludedExercises + " / " + numberOfExercises);

    }

    @Override
    public int getItemCount() {
        return daysList.size();
    }

    public class DaysViewHolder extends RecyclerView.ViewHolder {
        TextView daysTextView;
        TextView countTextView;

        public DaysViewHolder(@NonNull View itemView) {
            super(itemView);
            daysTextView = itemView.findViewById(R.id.dayTextView);
            countTextView = itemView.findViewById(R.id.countTextView);

        }
    }

}



