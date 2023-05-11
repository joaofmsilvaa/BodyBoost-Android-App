package com.example.bodyboost.Exercise_classes;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Days.class}, version = 1)
public abstract class DaysDatabase extends RoomDatabase {

    public abstract DaysDao getDaysDao();

    private static DaysDatabase INSTANCE;

    public static DaysDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DaysDatabase.class, "daysDatabase").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                        }
                    })

                    .build();
        }
        return INSTANCE;
    }

}
