package com.example.bodyboost;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.DaysDao;
import com.example.bodyboost.Report_classes.Report;
import com.example.bodyboost.Report_classes.ReportDao;

@Database(entities = {Report.class, Days.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ReportDao getReportDao();
    public abstract DaysDao getDaysDao();
    private static AppDatabase INSTANCE;


    public static com.example.bodyboost.AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "AppDatabase").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Monday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Tuesday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Wednesday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Thursday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Friday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Saturday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Sunday', 10, 0)");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}

