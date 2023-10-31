package com.example.bodyboost.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.Report;
import com.example.bodyboost.models.ReportRepository;

import java.util.List;

// Must extend AndroidViewModel since we will be accessing a database
public class ReportViewModel extends AndroidViewModel {
    private ReportRepository repository;

    public ReportViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new ReportRepository(application.getApplicationContext());
    }

    public LiveData<List<Report>> getReports(int userId) {
        return repository.getReports(userId);
    }

    public Report getById(int reportId) {
        return repository.getById(reportId);
    }

    public void createReport(Report report) {
        this.repository.createReport(report);
    }

    public void deleteReport(Report report){

        this.repository.deleteReport(report);}

}

