package com.example.bodyboost.views;


import static com.example.bodyboost.views.HomeFragment.userId;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.models.DayWorkoutRepository;
import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.DayWorkoutDao;
import com.example.bodyboost.models.Days;
import com.example.bodyboost.R;
import com.example.bodyboost.models.databaseModels.UserCompletedDao;
import com.example.bodyboost.viewmodels.DayWorkoutViewModel;
import com.example.bodyboost.viewmodels.UserCompletedViewModel;
import com.example.bodyboost.viewmodels.UserPlanViewModel;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DaysViewHolder> {

    private DaysAdapterEventListener eventListener;
    private List<Days> daysList;
    private UserCompletedViewModel userCompletedViewModel;
    private UserPlanViewModel userPlanViewModel;
    private DayWorkoutViewModel dayWorkoutViewModel;

    public DaysAdapter(DaysAdapterEventListener eventLister, List<Days> days) {
        this.eventListener = eventLister;
        this.daysList = days;
    }


    @NonNull
    @Override
    public DaysAdapter.DaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_days, parent, false);
        return new DaysAdapter.DaysViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull DaysAdapter.DaysViewHolder holder, int position) {
        Days days = this.daysList.get(position);
        userCompletedViewModel = new ViewModelProvider((ViewModelStoreOwner) holder.context).get(UserCompletedViewModel.class);
        userPlanViewModel = new ViewModelProvider((ViewModelStoreOwner) holder.context).get(UserPlanViewModel.class);
        dayWorkoutViewModel = new ViewModelProvider((ViewModelStoreOwner) holder.context).get(DayWorkoutViewModel.class);

        int planForUser = userPlanViewModel.getUserPlanById(userId);
        int numOfExercises = userCompletedViewModel.countExercisesForUser(userId,days.getDayId());
        int ammountCompleted = userCompletedViewModel.ammountCompleted(userId, days.getDayId());

        holder.daysTextView.setText(days.getDay());
        holder.countTextView.setText(ammountCompleted + " / " + numOfExercises);
        holder.descriptionTextView.setText(dayWorkoutViewModel.getDescriptionByDayPlan(days.getDayId(),planForUser));

        holder.dayCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int currentDay = days.getDayId();

                if (eventListener != null) eventListener.onDayClicked(currentDay, v);

            }
        });

    }

    @Override
    public int getItemCount() {
        return daysList.size();
    }

    public class DaysViewHolder extends RecyclerView.ViewHolder {

        Context context;
        TextView daysTextView;
        TextView countTextView;

        TextView descriptionTextView;

        TextView dayCard;
        public DaysViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            daysTextView = itemView.findViewById(R.id.dayTextView);
            countTextView = itemView.findViewById(R.id.countTextView);
            dayCard = itemView.findViewById(R.id.dayCard);
            descriptionTextView = itemView.findViewById(R.id.cardDescriptionTV);

        }
    }

    public interface DaysAdapterEventListener {
        void onDayClicked(int dayId, View v);

    }
}





