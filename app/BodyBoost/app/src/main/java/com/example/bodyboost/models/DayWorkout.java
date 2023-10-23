package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DayWorkout {

    @PrimaryKey(autoGenerate = true)
    int DayWorkoutId;

    int dayId;

    int planId;

    String description;

    public DayWorkout(int DayWorkoutId, int dayId, int planId, String description) {
        this.DayWorkoutId = DayWorkoutId;
        this.dayId = dayId;
        this.planId = planId;
        this.description = description;
    }

    public int getDayId() {
        return dayId;
    }

    public int getPlanId() {
        return planId;
    }

    public String getDescription() {
        return description;
    }
}
