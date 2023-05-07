package com.example.bodyboost.Report_classes;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Report {

    @PrimaryKey(autoGenerate = true)
    private int reportID;

    @ColumnInfo
<<<<<<< Updated upstream
    private String weight;

    public Report(int reportID,String weight) {
=======
    private int weight;

    public Report(int reportID,int weight) {
>>>>>>> Stashed changes
        this.reportID= reportID;
        this.weight = weight;

    }

<<<<<<< Updated upstream
    public String getWeight() {
=======
    public int getWeight() {
>>>>>>> Stashed changes
        return weight;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

<<<<<<< Updated upstream
    public void setWeight(String weight) {
=======
    public void setWeight(int weight) {
>>>>>>> Stashed changes
        this.weight = weight;
    }


}
