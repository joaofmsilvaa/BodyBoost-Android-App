package com.example.bodyboost.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.databaseModels.ReportDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReportRepository {
    private ReportDao reportDao;
    private Executor executor = Executors.newSingleThreadExecutor(); // To handle background tasks

    public ReportRepository(Context context) {
        // Initialize the DAO
        this.reportDao = AppDatabase.getInstance(context).getReportDao();
    }

    public LiveData<List<Report>> getReports(int userId) {
        return this.reportDao.getAll(userId);
    }

    public Report getById(int reportId){
        return this.reportDao.getById(reportId);
    }

    public void createReport(Report report) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                reportDao.insert(report);
            }
        });
    }

    public void deleteReport(Report report){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                reportDao.delete(report);
            }
        });
    }
}

