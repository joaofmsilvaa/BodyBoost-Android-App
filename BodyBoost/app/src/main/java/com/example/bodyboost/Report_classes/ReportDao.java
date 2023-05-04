package com.example.bodyboost.Report_classes;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReportDao {

    @Query("SELECT * FROM report")
    List<Report> getAll();



}
