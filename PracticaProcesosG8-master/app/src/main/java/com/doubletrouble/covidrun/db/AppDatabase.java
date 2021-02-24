package com.doubletrouble.covidrun.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.doubletrouble.covidrun.model.Plan;
import com.doubletrouble.covidrun.model.Planes_Usuario;
import com.doubletrouble.covidrun.model.Usuario;

@Database(entities = {Usuario.class, Plan.class, Planes_Usuario.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsuarioDAO usuarioDao();
    public abstract PlanDAO planDao();
    public abstract PlanesUsuarioDAO planesUsuarioDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "CovidRUNdb_v3.3")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}