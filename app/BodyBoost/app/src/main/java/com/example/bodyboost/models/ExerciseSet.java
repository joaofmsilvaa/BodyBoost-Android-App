package com.example.bodyboost.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;


@Entity(tableName = "ExerciseSet",
        primaryKeys = {"dayId", "exerciseId"},
        foreignKeys = {
                @ForeignKey(entity = Days.class,
                        parentColumns = "dayId",
                        childColumns = "dayId",
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {@Index("dayId")}
)
public class ExerciseSet {

    @ColumnInfo(name = "dayId")
    int dayId;

    @ColumnInfo(name = "exerciseId")
    int exerciseId;

    @ColumnInfo(name = "orderIndex")
    int orderIndex;

    @ColumnInfo(name = "repetitions")
    int repetitions;

    @ColumnInfo(name = "time")
    String time;

    public ExerciseSet(int dayId, int exerciseId, int orderIndex, int repetitions, String time) {
        this.dayId = dayId;
        this.exerciseId = exerciseId;
        this.orderIndex = orderIndex;
        this.repetitions = repetitions;
        this.time = time;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public String getTime() {
        return time;
    }

    public int getDayId() {
        return dayId;
    }

}


