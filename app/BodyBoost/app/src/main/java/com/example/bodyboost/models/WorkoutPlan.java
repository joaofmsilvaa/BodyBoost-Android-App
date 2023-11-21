package com.example.bodyboost.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;


@Entity(primaryKeys = {"planId", "dayId", "exerciseId"})
public class WorkoutPlan {

    @ColumnInfo(name = "planId")
    int planId;

    @ColumnInfo(name = "dayId")
    int dayId;

    @ColumnInfo(name = "exerciseId")
    int exerciseId;

    @ColumnInfo(name = "type")
    String type;

    public WorkoutPlan(int planId, int dayId, int exerciseId, String type) {
        this.planId = planId;
        this.dayId = dayId;
        this.exerciseId = exerciseId;
        this.type = type;
    }

    public int getPlanId() {
        return planId;
    }

    public int getDayId() {
        return dayId;
    }

    public int getExerciseId() {
        return exerciseId;
    }
}
