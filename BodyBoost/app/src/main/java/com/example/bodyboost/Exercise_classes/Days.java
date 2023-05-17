package com.example.bodyboost.Exercise_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Days {

    @PrimaryKey(autoGenerate = true)
    private int dayId;

    private String day;
    private int numberOfExercises;
    private int concludedExercises;

    public Days(int dayId,String day, int numberOfExercises, int concludedExercises) {
        this.dayId = dayId;
        this.day = day;
        this.numberOfExercises = numberOfExercises;
        this.concludedExercises = concludedExercises;
    }

    public int getDayId() {
        return dayId;
    }
    public String getDay() {
        return day;
    }

    public int getNumberOfExercises() {
        return numberOfExercises;
    }

    public int getConcludedExercises() {
        return concludedExercises;
    }
}

