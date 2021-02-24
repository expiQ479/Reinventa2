package com.doubletrouble.covidrun.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.doubletrouble.covidrun.model.Planes_Usuario;
import com.doubletrouble.covidrun.model.Usuario;

import java.util.List;

@Dao
public interface PlanesUsuarioDAO {
    @Query("SELECT * FROM planes_usuario WHERE userId = :nombreUsuario")
    List<Planes_Usuario> getPlanesDelUsuario(String nombreUsuario);

    @Insert
    void registerNewPlan(Planes_Usuario planes_usuario);
}
