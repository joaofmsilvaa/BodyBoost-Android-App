package com.example.bodyboost;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.ExerciseSet;


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

    public String getType() {
        return type;
    }
}
