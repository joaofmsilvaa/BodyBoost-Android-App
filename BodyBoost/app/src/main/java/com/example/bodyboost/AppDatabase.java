package com.example.bodyboost;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.DaysDao;
import com.example.bodyboost.Exercise_classes.ExerciseSet;
import com.example.bodyboost.Exercise_classes.ExerciseSetDao;
import com.example.bodyboost.Report_classes.Report;
import com.example.bodyboost.Report_classes.ReportDao;

@Database(entities = {Report.class, Days.class, Exercise.class, ExerciseSet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ReportDao getReportDao();
    public abstract DaysDao getDaysDao();
    public abstract ExerciseSetDao getExerciseSetDao();

    // Gets an instance of the app database
    private static AppDatabase INSTANCE;


    public static com.example.bodyboost.AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "AppDatabase").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            // Days and exercises
                            db.execSQL("INSERT INTO Days ('dayId','day') Values (0,'Monday')");
                            db.execSQL("INSERT INTO Days ('day') Values ('Tuesday')");
                            db.execSQL("INSERT INTO Days ('day') Values ('Wednesday')");
                            db.execSQL("INSERT INTO Days ('day') Values ('Thursday')");
                            db.execSQL("INSERT INTO Days ('day') Values ('Friday')");
                            db.execSQL("INSERT INTO Days ('day') Values ('Saturday')");
                            db.execSQL("INSERT INTO Days ('day') Values ('Sunday')");

                            // Exercises
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Push-up chair dips')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Wall push-ups')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Jump rope')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Knee push-ups')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Squat')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Side Jump')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Deep crunch')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Side leg raises')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Donkey kicks')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('One-arm push-ups')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Wide-arm push-ups')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Diamond push-ups')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Abdominal crunch')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Mountain climbers')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Heel touchh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Russian twist')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Leg raises')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Jumping jacks')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Burpees')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Skipping')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Air bicycle')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Plank')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('V-sit crunch')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Extended-arm crunch')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Barbell bench press')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Pull-ups')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Straight Supine with Bar')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Chest in parallel')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Crucifix on the fly')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Push-ups on the wall')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Front raise with dumbbells')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Fixed barbell lifts')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Closed barbell pulldown')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Isometric squat')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Bulgarian squat')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Chair extensor')");
                            db.execSQL("INSERT INTO Exercise('exerciseName') Values ('Jumping jacks')");

                            // Exercise set

                            // Exercise set - Monday
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex' ,'repetitions', 'time') Values (0, 1 ,1 ,10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex' , 'repetitions', 'time') Values (0, 2, 2 , 20 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (0, 3, 3 ,0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (0, 5 , 4 ,0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (0, 11 , 5 ,0  , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (0, 12 , 6 ,0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (0, 13 , 7, 0 , '30 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (0, 28 , 8, 15 , null)");

                            // Exercise set - Tuesday
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (1, 4 , 1 ,0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (1, 20 , 2 ,0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (1, 23 , 3 , 0 , '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (1, 26 , 4 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (1, 28 , 5 , 12  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (1, 33 , 6 , 10 , null)");

                            // Exercise set - Wednesday
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 1 , 1, 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 3 , 2, 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 5 , 3, 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 11 , 4, 14 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 12 , 5, 14  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 26 , 6, 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 27 , 7, 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 28 , 8, 8  , null)");

                            // Exercise set - Thursday
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (3, 6 , 1, 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (3, 7 , 2, 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (3, 8 , 3, 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (3, 9 , 4 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (3, 10 , 5 , 10  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (3, 13 , 6 , 14, null)");

                            // Exercise set - Friday
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (4, 4 , 1, 0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (4, 20 , 2, 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (4, 23, 3, 0 , '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (4, 34 , 4, 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (4, 35 , 5, 15  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (4, 36 , 6, 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (4, 37 , 7, 10  , null)");

                            // Exercise set - Saturday
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (5, 14 , 1, 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (5, 15 , 2, 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (5, 16, 3 ,15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (5, 17 , 4 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (5, 18 , 5 , 15  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (5, 24 , 6 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (5, 25 , 7 , 10  , null)");

                            // Exercise set - Sunday
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (6, 19, 1 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (6, 20 , 2 ,0 , '2 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (6, 21 , 3 , 0  , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (6, 22 , 4 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (6, 23 , 5 , 0  , '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (6, 29 , 6 , 8 , null)");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}

