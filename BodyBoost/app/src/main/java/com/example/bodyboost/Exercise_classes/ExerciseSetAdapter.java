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
import com.example.bodyboost.Report_classes.Report;
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
            if (userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, dayId, exerciseID) == 1) {
                holder.weightCard.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
            } else {
                holder.weightCard.setBackgroundColor(ContextCompat.getColor(context, R.color.mainRed));
            }
        }

        // TO-DO - corrigir o bug de marcar um exercício como completo
        holder.exerciseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int test = userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, HomeFragment.getCurrentDay(), exerciseID);

                if (test == 1) {

                    userCompletedDao.updateExerciseCompleted(0,dayId,HomeFragment.userId,exerciseID);
                    eventListener.onExerciseCompleted();
                } else {

                    userCompletedDao.updateExerciseCompleted(1,dayId,HomeFragment.userId,exerciseID);
                    eventListener.onExerciseCompleted();
                }
            }
        });

        holder.exerciseNameTextView.setText(exercise.getExerciseName());

        if (exerciseSet.getRepetitions() == 0) {
            holder.timeRepetitionsTextView.setText(exerciseSet.getTime());
        } else {
            holder.timeRepetitionsTextView.setText(exerciseSet.getRepetitions() + "x");
        }
    }

    @Override
    public int getItemCount() {
        return exerciseSetList.size();
    }

    public void updateData(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
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