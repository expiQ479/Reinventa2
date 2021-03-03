package com.doubletrouble.covidrun.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;

import com.doubletrouble.covidrun.model.Plan;

import java.util.List;

@Dao
public interface PlanDAO {
    @Query("SELECT * FROM planes")
    List<Plan> getAll();

    @Query("SELECT planes.* FROM planes, planes_usuario WHERE planes_usuario.userId = :nombreUsuario AND planes_usuario.planId = planes.id ORDER BY planes_usuario.date DESC")
    List<Plan> getListForPrinting(String nombreUsuario);

    @Query("SELECT * FROM planes WHERE rowid = :id LIMIT 1")
    Plan findConcretePlan(int id);

    @Query("SELECT COUNT(*) FROM planes")
    int howManyPlans();

    @Insert
    long insertPlan(Plan plan);

    @Delete
    void deletePlan(Plan plan);

}
