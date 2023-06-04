package com.example.bodyboost.Exercise_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.Exercise;
import com.example.bodyboost.HomeFragment;
import com.example.bodyboost.R;
import com.example.bodyboost.UserCompleted;
import com.example.bodyboost.UserCompletedDao;

import java.util.List;

public class ExerciseSetAdapter extends RecyclerView.Adapter<ExerciseSetAdapter.MyViewHolder> {
    private List<ExerciseSet> exerciseSetList;
    private List<Exercise> exerciseList;
    private Context context;
    private ExerciseSetAdapterEventListener eventListener;

    public ExerciseSetAdapter(ExerciseSetAdapterEventListener eventListener, List<ExerciseSet> exerciseSetList, List<Exercise> exerciseList, Context context) {
        this.eventListener = eventListener;
        this.exerciseSetList = exerciseSetList;
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExerciseSetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);
        return new MyViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseSetAdapter.MyViewHolder holder, int position) {
        AppDatabase db = AppDatabase.getInstance(context);
        UserCompletedDao userCompletedDao = db.getUserCompletedDao();

        ExerciseSet exerciseSet = exerciseSetList.get(position);
        Exercise exercise = exerciseList.get(position);

        int exerciseID = exercise.getExerciseId();

        int dayId = exerciseSet.getDayId();

        if (holder.weightCard != null) {
            if (userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, dayId, exerciseID)) {
                holder.weightCard.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
            } else {
                holder.weightCard.setBackgroundColor(ContextCompat.getColor(context, R.color.mainRed));
            }
        }

        holder.exerciseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, dayId, exerciseID)) {
                    UserCompleted userCompleted = new UserCompleted(0, HomeFragment.userId, dayId, exerciseID, false);

                    userCompletedDao.updateCompleted(userCompleted);
                    eventListener.onExerciseCompleted();
                } else {
                    UserCompleted userCompleted = new UserCompleted(0, HomeFragment.userId, dayId, exerciseID, true);

                    userCompletedDao.updateCompleted(userCompleted);
                    eventListener.onExerciseCompleted();
                }
            }
        });

        holder.exerciseNameTextView.setText(exercise.getExerciseName());

        if (exerciseSet.getRepetitions() == 0) {
            holder.timeRepetitionsTextView.setText(exerciseSet.getTime());
        } else {
            holder.timeRepetitionsTextView.setText(Integer.toString(exerciseSet.getRepetitions()));
        }
    }

    @Override
    public int getItemCount() {
        return exerciseSetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView timeRepetitionsTextView;
        private TextView exerciseNameTextView;
        private View weightCard;
        private Button exerciseDoneButton;

        public MyViewHolder(final View view, Context context) {
            super(view);
            this.context = context;
            exerciseNameTextView = view.findViewById(R.id.exerciseName);
            timeRepetitionsTextView = view.findViewById(R.id.timeRepetitionsTextView);
            weightCard = view.findViewById(R.id.weightCard);
            exerciseDoneButton = view.findViewById(R.id.exerciseDoneButton);
        }
    }

    public interface ExerciseSetAdapterEventListener {
        void onExerciseCompleted();
    }
}