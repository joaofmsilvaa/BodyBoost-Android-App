package com.example.bodyboost.Report_classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReportMemoryDatabase {

    private static ArrayList<Report> reportList;

    private static ArrayList<Report> initializeList() {
        if (reportList == null) {
            reportList = new ArrayList<>();
            reportList.add(new Report(1,"53"));
            reportList.add(new Report(2,"65"));
        }
        return reportList;
    }

    public static ArrayList<Report> getAllReports() {
        return initializeList();
    }

    public static Report getReportForPosition(int position) {
        return initializeList().get(position);
    }

}
