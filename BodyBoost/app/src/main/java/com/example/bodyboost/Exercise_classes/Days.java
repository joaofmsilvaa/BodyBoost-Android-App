package com.example.bodyboost.Exercise_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Days {

    @PrimaryKey(autoGenerate = true)
    private int dayId;

    private String day;

    public Days(int dayId,String day) {
        this.dayId = dayId;
        this.day = day;

    }

    public int getDayId() {
        return dayId;
    }
    public String getDay() {
        return day;
    }


}

