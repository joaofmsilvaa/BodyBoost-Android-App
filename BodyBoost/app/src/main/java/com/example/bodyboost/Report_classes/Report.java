package com.example.bodyboost.Report_classes;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Report {

    @PrimaryKey(autoGenerate = true)
    private int reportID;

    private int weight;

    private String date;

    public Report(int reportID,int weight, String date) {
        this.reportID= reportID;
        this.weight = weight;
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public int getReportID() {
        return reportID;
    }

    public String getDate() {
        return date;
    }
}
