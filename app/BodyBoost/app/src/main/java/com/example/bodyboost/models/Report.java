package com.example.bodyboost.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Report {

    @PrimaryKey(autoGenerate = true)
    private int reportID;

    private int userId;

    private float weight;

    private long date;

    public Report(int reportID, int userId ,float weight, long date) {
        this.reportID = reportID;
        this.userId = userId;
        this.weight = weight;
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public int getUserId() {
        return userId;
    }

    public int getReportID() {
        return reportID;
    }

    public long getDate() {
        return date;
    }
}
