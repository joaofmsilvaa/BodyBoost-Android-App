package com.example.bodyboost.Report_classes;

public class Report {

    private int reportID;
    private String weight;

    public Report(int reportID,String weight) {
        this.reportID= reportID;
        this.weight = weight;

    }

    public String getWeight() {
        return weight;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


}
