package com.example.bodyboost.Exercise_classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.Exercise;
import com.example.bodyboost.R;

import java.util.List;

public class ExerciseSetAdapter extends RecyclerView.Adapter<ExerciseSetAdapter.MyViewHolder>{
    private List<ExerciseSet> exerciseSetList;

    public ExerciseSetAdapter(List<ExerciseSet> exerciseSetList){
        this.exerciseSetList = exerciseSetList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView timeRepetitionsTextView;

        public MyViewHolder(final View view){
            super(view);

            timeRepetitionsTextView = view.findViewById(R.id.timeRepetitionsTextView);
        }
    }

    @NonNull
    @Override
    public ExerciseSetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseSetAdapter.MyViewHolder holder, int position) {
        ExerciseSet exerciseSet = this.exerciseSetList.get(position);

        if(exerciseSet.getRepetitions() == 0){
            holder.timeRepetitionsTextView.setText(exerciseSet.getTime());
        }
        else{
            holder.timeRepetitionsTextView.setText(exerciseSet.getRepetitions());
        }

    }

    @Override
    public int getItemCount() {
        return exerciseSetList.size();
    }

}