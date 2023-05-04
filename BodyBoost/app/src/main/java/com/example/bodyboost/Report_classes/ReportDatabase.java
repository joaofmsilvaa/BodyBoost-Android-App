package com.example.bodyboost.Report_classes;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Report.class, version = 1)
public abstract class ReportDatabase extends RoomDatabase {

    public abstract ReportDao getReportDao();

    private static ReportDatabase INSTANCE;

    public static ReportDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ReportDatabase.class, "contactsDB").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Report VALUES (1, 23)");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}
