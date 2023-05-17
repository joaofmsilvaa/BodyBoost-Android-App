package com.example.bodyboost.Exercise_classes;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;


@Entity(primaryKeys = {"dayId", "exerciseId"}, foreignKeys = {

        @ForeignKey(entity = Days.class,
        parentColumns = "dayId",
        childColumns = "dayId",
        onDelete = ForeignKey.CASCADE)
})
public class ExerciseSet {

    int dayId;

    int exerciseId;

    int repetitions;

    String time;

    public ExerciseSet(int dayId, int exerciseId, int repetitions, String time) {
        this.dayId = dayId;
        this.exerciseId = exerciseId;
        this.repetitions = repetitions;
        this.time = time;
    }

    public int getdayID() {
        return dayId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public String getTime() {
        return time;
    }
}


