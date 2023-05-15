package com.example.bodyboost.Exercise_classes;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.bodyboost.Exercise;

@Entity(primaryKeys = {"exerciseSetID", "exerciseId"}, foreignKeys = {@ForeignKey(entity = Exercise.class,
        parentColumns = "exerciseId",
        childColumns = "exerciseId",
        onDelete = ForeignKey.CASCADE)
})
public class ExerciseSet {

    int exerciseSetID;

    int exerciseId;

    int repetitions;

    String time;

    public ExerciseSet(int exerciseSetID, int exerciseId, int repetitions, String time) {
        this.exerciseSetID = exerciseSetID;
        this.exerciseId = exerciseId;
        this.repetitions = repetitions;
        this.time = time;
    }

    public int getExerciseSetID() {
        return exerciseSetID;
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
