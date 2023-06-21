package com.example.bodyboost.Exercise_classes;

import android.content.Context;
import android.util.Log;
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

import org.w3c.dom.Text;

import java.util.List;

public class ExerciseSetAdapter extends RecyclerView.Adapter<ExerciseSetAdapter.MyViewHolder> {

    private int day;
    private List<Exercise> exerciseList;
    private Context context;
    private ExerciseSetAdapterEventListener eventListener;

    public ExerciseSetAdapter(ExerciseSetAdapterEventListener eventListener, int dayId ,List<Exercise> exerciseList, Context context) {
        this.eventListener = eventListener;
        this.day = dayId;
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
        ExerciseSetDao exerciseSetDao = db.getExerciseSetDao();

        Exercise exercise = exerciseList.get(position);

        ExerciseSet getExerciseInfos = exerciseSetDao.getInfosForExercise(exercise.getExerciseId());

        holder.exerciseNameTextView.setText(exercise.getExerciseName());
        holder.exerciseDescTextView.setText(exercise.getExerciseDescription());

        if (getExerciseInfos.getRepetitions() == 0) {
            holder.timeRepetitionsTextView.setText(getExerciseInfos.getTime());
        } else {
            holder.timeRepetitionsTextView.setText(getExerciseInfos.getRepetitions() + "x");
        }

        if (holder.weightCard != null) {
            if (userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, day, exercise.getExerciseId()) == 1) {
                holder.weightCard.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.rounded_exercise_completed) );
                holder.exerciseDoneButton.setText("DONE");
            } else {
                holder.weightCard.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.rounded_exercise_uncompleted) );
                holder.exerciseDoneButton.setText("TO-DO");
            }
        }

        holder.exerciseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int test = userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, day, exercise.getExerciseId());

                if (test == 1) {

                    userCompletedDao.updateExerciseCompleted(0,day,HomeFragment.userId,exercise.getExerciseId());
                    eventListener.onExerciseCompleted();
                } else {

                    userCompletedDao.updateExerciseCompleted(1,day,HomeFragment.userId,exercise.getExerciseId());
                    eventListener.onExerciseCompleted();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public void updateData(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView timeRepetitionsTextView;
        private TextView exerciseNameTextView;
        private TextView exerciseDescTextView;
        private View weightCard;
        private Button exerciseDoneButton;

        public MyViewHolder(final View view, Context context) {
            super(view);
            this.context = context;
            exerciseNameTextView = view.findViewById(R.id.exerciseName);
            exerciseDescTextView = view.findViewById(R.id.exerciseDescTextView);
            timeRepetitionsTextView = view.findViewById(R.id.timeRepetitionsTextView);
            weightCard = view.findViewById(R.id.weightCard);
            exerciseDoneButton = view.findViewById(R.id.exerciseDoneButton);
        }
    }

    public interface ExerciseSetAdapterEventListener {
        void onExerciseCompleted();
    }
}